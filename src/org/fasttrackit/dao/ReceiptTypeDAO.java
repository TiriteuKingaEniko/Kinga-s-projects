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
import org.fasttrackit.pojo.ReceiptType;

public class ReceiptTypeDAO {

	// returneaza un receipt type dupa id

	public ReceiptType getReceiptTypeById(int id) throws SQLException {
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

	// returneaza un receipt type dupa nume

	public ReceiptType getReceiptTypeByName(String name) throws SQLException {
		ReceiptType rt = null;
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String sqlString = "select * from receipt_type where name=?";
		PreparedStatement stmt = con.prepareStatement(sqlString);
		stmt.setString(1, name);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {

			int id = rs.getInt("id");
			String description = rs.getString("description");
			rt = new ReceiptType(id, name, description);
		}

		helper.closeConnection(con);
		return rt;
	}

	// returneaza o lista cu toate receipttype-urile din BD

	public ArrayList<ReceiptType> receiptTypeList() throws SQLException {
		ArrayList<ReceiptType> list = new ArrayList<ReceiptType>();
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String sqlString = "select * from receipt_type";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlString);

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String description = rs.getString("description");

			ReceiptType r = new ReceiptType(id, name, description);
			list.add(r);
		}

		helper.closeConnection(con);
		return list;
	}

}
