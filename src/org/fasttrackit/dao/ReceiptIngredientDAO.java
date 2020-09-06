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

public class ReceiptIngredientDAO {

	// returneaza toata lista de cumparaturi
	public ArrayList<ReceiptIngredient> getToBuyList() throws SQLException {
		ArrayList<ReceiptIngredient> result = new ArrayList<ReceiptIngredient>();
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String sqlString = "select * from to_buy_list order by ingredient_name";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlString);

		while (rs.next()) {
			String ingredientName = rs.getString("ingredient_name");
			float quantity = rs.getFloat("quantity");
			String unit = rs.getString("unit");
			ReceiptIngredient ri = new ReceiptIngredient();
			ri.setIngredient(new Ingredient(0, ingredientName, unit));
			ri.setQuantity(quantity);
			result.add(ri);
		}

		helper.closeConnection(con);
		return result;
	}

	// sterge ingredientele unei retete pe lista de cumparaturi
	public void deleteIngredientsOnToBuyListbyReceipt(Receipt receipt) throws SQLException {
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();
		int i = 0;
		while (i < receipt.getIngredientList().size()) {
			String ingredientName = receipt.getIngredientList().get(i).getIngredient().getName();
			String unit = receipt.getIngredientList().get(i).getIngredient().getUnit();
			float quantity = receipt.getIngredientList().get(i).getQuantity();
			deleteIngredientOnToBuyList(ingredientName, quantity, unit);
			i++;
		}
		helper.closeConnection(con);

	}

	// sterge un ingredient pe lista de cumparaturi
	public void deleteIngredientOnToBuyList(String ingredientName, float quantity, String unit) throws SQLException {
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String sqlString = "select * from to_buy_list where ingredient_name=? and unit=? ";
		PreparedStatement stmt = con.prepareStatement(sqlString);
		stmt.setString(1, ingredientName);
		stmt.setString(2, unit);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			float q = rs.getFloat("quantity");
			if (q - quantity >= 0) {
				updateQuantity(ingredientName, q - quantity, unit);
			} else {
				updateQuantity(ingredientName, 0, unit);
			}
		}
		helper.closeConnection(con);

	}

	// adauga ingredientele unei retete pe lista de cumparaturi
	public void addIngredientsOnToBuyListbyReceipt(Receipt receipt) throws SQLException {
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();
		int i = 0;
		while (i < receipt.getIngredientList().size()) {
			String ingredientName = receipt.getIngredientList().get(i).getIngredient().getName();
			String unit = receipt.getIngredientList().get(i).getIngredient().getUnit();
			float quantity = receipt.getIngredientList().get(i).getQuantity();
			addIngredientOnToBuyList(ingredientName, quantity, unit);
			i++;
		}
		helper.closeConnection(con);

	}

	// adauga un ingredient pe lista de cumparaturi
	public void addIngredientOnToBuyList(String ingredientName, float quantity, String unit) throws SQLException {
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String sqlString = "select * from to_buy_list where ingredient_name=? and unit=? ";
		PreparedStatement stmt = con.prepareStatement(sqlString);
		stmt.setString(1, ingredientName);
		stmt.setString(2, unit);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			float q = rs.getFloat("quantity");
			updateQuantity(ingredientName, quantity + q, unit);
		} else {
			sqlString = "insert into to_buy_list (ingredient_name, quantity, unit)" + "values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sqlString);
			ps.setString(1, ingredientName);
			ps.setFloat(2, quantity);
			ps.setString(3, unit);
			ps.executeUpdate();
		}
		helper.closeConnection(con);

	}

	// update cantitate pentru un ingredient

	public void updateQuantity(String ingredientName, float quantity, String unit) throws SQLException {
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String insertReceipt = "update to_buy_list set quantity=? where ingredient_name=? and unit=?";
		PreparedStatement ps = con.prepareStatement(insertReceipt);
		ps.setFloat(1, quantity);
		ps.setString(2, ingredientName);
		ps.setString(3, unit);
		ps.executeUpdate();

		helper.closeConnection(con);
	}

	// update receiptIngredient list pentru o reteta

	public void updateReceiptIngredient(ArrayList<ReceiptIngredient> receiptIngredientList) throws SQLException {
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		int i = 0;
		while (i < receiptIngredientList.size()) {
			String insertReceipt = "update receipt_ingredient set quantity=? where receipt_id=? and ingredient_id=?";
			PreparedStatement ps = con.prepareStatement(insertReceipt);
			ps.setFloat(1, receiptIngredientList.get(i).getQuantity());
			ps.setInt(2, receiptIngredientList.get(i).getReceiptId());
			ps.setInt(3, receiptIngredientList.get(i).getIngredientId());
			ps.executeUpdate();
			i++;
		}
		helper.closeConnection(con);
	}

	// sterge un ReceiptIngredient dupa id-ul retetei

	public void deleteReceiptIngredientByReceiptId(int receiptId) throws SQLException {
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String sqlstr = "delete from receipt_ingredient where receipt_id=?";
		PreparedStatement ps = con.prepareStatement(sqlstr);
		ps.setInt(1, receiptId);
		ps.executeUpdate();

		helper.closeConnection(con);
	}

	// adauga un ReceiptIngredient nou in BD

	public void addReceiptIngredient(ReceiptIngredient receiptIngredient) throws SQLException {
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String sqlString = "select * from receipt_ingredient where receipt_id=? and ingredient_id=? ";
		PreparedStatement stmt = con.prepareStatement(sqlString);
		stmt.setInt(1, receiptIngredient.getReceiptId());
		stmt.setInt(2, receiptIngredient.getIngredientId());
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			ArrayList<ReceiptIngredient> rilist = new ArrayList<ReceiptIngredient>();
			float q = rs.getFloat("quantity");
			receiptIngredient.setQuantity(receiptIngredient.getQuantity() + q);
			rilist.add(receiptIngredient);
			updateReceiptIngredient(rilist);
		} else {
			String insertReceiptIngredient = "insert into receipt_ingredient (receipt_id, ingredient_id, quantity)"
					+ "values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertReceiptIngredient);

			ps.setInt(1, receiptIngredient.getReceiptId());
			ps.setInt(2, receiptIngredient.getIngredientId());
			ps.setFloat(3, receiptIngredient.getQuantity());

			ps.executeUpdate();
		}
		helper.closeConnection(con);
	}

}
