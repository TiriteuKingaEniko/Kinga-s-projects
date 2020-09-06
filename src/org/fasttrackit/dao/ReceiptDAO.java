package org.fasttrackit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.fasttrackit.helpers.DBhelpers;
import org.fasttrackit.pojo.Ingredient;
import org.fasttrackit.pojo.Receipt;
import org.fasttrackit.pojo.ReceiptIngredient;
import org.fasttrackit.pojo.ReceiptType;

public class ReceiptDAO {

	// cauta retetele care contin anumite cuvinte in numele lor.returneaza un
	// arraylist de retete

	public ArrayList<Receipt> findWhat(String what) throws SQLException {
		ArrayList<Receipt> result = new ArrayList<Receipt>();
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String sqlString = "select * from receipt where name like ? order by name ";
		PreparedStatement stmt = con.prepareStatement(sqlString);
		stmt.setString(1, '%' + what + '%');
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			Receipt r = new Receipt();
			r = returnReceipt(id);
			result.add(r);
		}

		helper.closeConnection(con);
		return result;
	}

	// update o reteta noua
	public void updateReceipt(Receipt receipt) throws SQLException {
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String insertReceipt = "update receipt set name=?, description=?, preparing_minutes=?, receipt_type_id=? where id=?";
		PreparedStatement ps = con.prepareStatement(insertReceipt);

		ps.setString(1, receipt.getName());
		ps.setString(2, receipt.getDescription());
		ps.setFloat(3, receipt.getPreparingMinutes());
		ps.setInt(4, receipt.getType().getId());
		ps.setInt(5, receipt.getId());

		ps.executeUpdate();

		ReceiptIngredientDAO ridao = new ReceiptIngredientDAO();
		ridao.updateReceiptIngredient(receipt.getIngredientList());

		helper.closeConnection(con);
	}

	// sterge o reteta dupa ID din BD

	public void deleteReceipt(int id) throws SQLException {
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String sqlstr = "delete from receipt where id=?";
		PreparedStatement ps = con.prepareStatement(sqlstr);
		ps.setInt(1, id);
		ps.executeUpdate();

		ReceiptIngredientDAO ridao = new ReceiptIngredientDAO();
		ridao.deleteReceiptIngredientByReceiptId(id);

		helper.closeConnection(con);
	}

	// adauga o reteta noua
	public void addReceipt(Receipt receipt) throws SQLException {
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String insertReceipt = "insert into receipt (name, description, preparing_minutes, receipt_type_id)"
				+ "values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insertReceipt);

		ps.setString(1, receipt.getName());
		ps.setString(2, receipt.getDescription());
		ps.setFloat(3, receipt.getPreparingMinutes());
		ps.setInt(4, receipt.getType().getId());

		ps.executeUpdate();

		helper.closeConnection(con);
	}

	// returneaza toate retetele din BD, de un anumit tip
	public ArrayList<Receipt> returnAllReceiptsbyType(int rtype) throws SQLException {
		ArrayList<Receipt> receiptList = new ArrayList<Receipt>();
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String sqlString = "select * from receipt  where receipt_type_id=? order by name";
		PreparedStatement stmt = con.prepareStatement(sqlString);
		stmt.setInt(1, rtype);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");

			Receipt r = new Receipt();
			r = returnReceipt(id);

			receiptList.add(r);
		}

		helper.closeConnection(con);
		return receiptList;
	}

	public ArrayList<Receipt> returnAllReceipts() throws SQLException {
		ArrayList<Receipt> receiptList = new ArrayList<Receipt>();
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String sqlString = "select * from receipt order by name";
		PreparedStatement stmt = con.prepareStatement(sqlString);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");

			Receipt r = new Receipt();
			r = returnReceipt(id);

			receiptList.add(r);
		}

		helper.closeConnection(con);
		return receiptList;
	}

	// cauta o reteta dupa nume

	public Receipt findReceiptByName(String name) throws SQLException {
		Receipt r = null;
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String sqlString = "select * from receipt where name=?";
		PreparedStatement stmt = con.prepareStatement(sqlString);
		stmt.setString(1, name);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {

			int id = rs.getInt("id");
			String description = rs.getString("description");
			Float prepMin = rs.getFloat("preparing_minutes");
			int type = rs.getInt("receipt_type_id");
			ReceiptTypeDAO rtdao = new ReceiptTypeDAO();
			ReceiptType rt = rtdao.getReceiptTypeById(type);
			ArrayList<ReceiptIngredient> receiptIngredient = findReceiptIngredientList(id);

			r = new Receipt(id, name, description, prepMin, receiptIngredient, rt);

		}

		helper.closeConnection(con);
		return r;
	}

	// cauta o reteta dupa id-ul retei.compune lista de ingrediente. returneaza o
	// Reteta

	public Receipt returnReceipt(int id) throws SQLException {
		Receipt r = null;
		ReceiptIngredient ri = null;
		IngredientDAO idao = new IngredientDAO();
		ArrayList<ReceiptIngredient> riList = new ArrayList<ReceiptIngredient>();
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String sqlString = "SELECT * FROM ingredient INNER JOIN receipt_ingredient ON receipt_ingredient.ingredient_id = ingredient.id INNER JOIN receipt ON receipt_ingredient.receipt_id = receipt.id WHERE receipt.id = ?";
		PreparedStatement stmt = con.prepareStatement(sqlString);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			String name = rs.getString(9);
			String description = rs.getString("description");
			Float prepMin = rs.getFloat("preparing_minutes");
			int type = rs.getInt("receipt_type_id");
			ReceiptType rt = findReceiptType(type);
			int ingredientId = rs.getInt(1);
			float quantity = rs.getFloat(7);
			ri = new ReceiptIngredient(0, id, ingredientId, quantity);
			ri.setIngredient(idao.findIngredientById(ingredientId));
			riList.add(ri);

			while (rs.next()) {
				ingredientId = rs.getInt(1);
				quantity = rs.getFloat(7);
				ri = new ReceiptIngredient(0, id, ingredientId, quantity);
				ri.setIngredient(idao.findIngredientById(ingredientId));
				riList.add(ri);
			}
			r = new Receipt(id, name, description, prepMin, riList, rt);

		}
		helper.closeConnection(con);
		return r;

	}

//cauta o reteta dupa id

	public Receipt findReceipt(int id) throws SQLException {
		Receipt r = null;
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String sqlString = "select * from receipt where id=?";
		PreparedStatement stmt = con.prepareStatement(sqlString);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {

			String name = rs.getString("name");
			String description = rs.getString("description");
			Float prepMin = rs.getFloat("preparing_minutes");
			int type = rs.getInt("receipt_type_id");

			ArrayList<ReceiptIngredient> receiptIngredient = findReceiptIngredientList(id);

			ReceiptType rt = findReceiptType(type);

			r = new Receipt(id, name, description, prepMin, receiptIngredient, rt);

		}

		helper.closeConnection(con);
		return r;
	}

//returneaza receiptType dupa ID-ul lui

	public ReceiptType findReceiptType(int id) throws SQLException {
		ReceiptType rt = null;
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();
		String sqlString = "select * from receipt_type where id=?";
		PreparedStatement stmt = con.prepareStatement(sqlString);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {

			String name = rs.getString("name");
			String description = rs.getString("description");

			rt = new ReceiptType(id, name, description);

		}
		helper.closeConnection(con);
		return rt;
	}

//returneaza lista de ingrediente pentru o reteta, dupa id-ul retetei
	public ArrayList<ReceiptIngredient> findReceiptIngredientList(int id) throws SQLException {
		ArrayList<ReceiptIngredient> alri = new ArrayList<ReceiptIngredient>();
		ReceiptIngredient ri = null;
		IngredientDAO idao = new IngredientDAO();
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String sqlString = "select * from receipt_ingredient where receipt_id=?";
		PreparedStatement stmt = con.prepareStatement(sqlString);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {

			int riid = rs.getInt("id");
			int ingredientId = rs.getInt("ingredient_id");
			float quantity = rs.getFloat("quantity");

			ri = new ReceiptIngredient(riid, id, ingredientId, quantity);
			ri.setIngredient(idao.findIngredientById(ingredientId));
			alri.add(ri);
		}
		helper.closeConnection(con);

		return alri;
	}

}
