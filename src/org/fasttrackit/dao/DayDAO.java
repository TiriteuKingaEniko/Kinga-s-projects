package org.fasttrackit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.fasttrackit.helpers.DBhelpers;
import org.fasttrackit.pojo.DayOfTheWeek;
import org.fasttrackit.pojo.Receipt;
import org.fasttrackit.pojo.ReceiptIngredient;

public class DayDAO {

	// sterge datele din to_buy_list

	public void resetToBuyList() throws SQLException {
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();
		Statement stmt1 = con.createStatement();
		String sqlString1 = "delete from to_buy_list";
		stmt1.executeUpdate(sqlString1);
		Statement stmt2 = con.createStatement();
		String sqlString2 = "ALTER TABLE to_buy_list AUTO_INCREMENT = 1";
		stmt2.executeUpdate(sqlString2);
		helper.closeConnection(con);
	}

	// sterge datele din day_receipts

	public void reset() throws SQLException {
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();
		Statement stmt1 = con.createStatement();
		String sqlString1 = "delete from day_receipts";
		stmt1.executeUpdate(sqlString1);
		Statement stmt2 = con.createStatement();
		String sqlString2 = "ALTER TABLE day_receipts AUTO_INCREMENT = 1";
		stmt2.executeUpdate(sqlString2);
		resetToBuyList();
		helper.closeConnection(con);
	}

	// returneaza id-ul ultimei zi de luni din BD

	public int getLastMondayId() throws SQLException {
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();
		int id = 0;
		String sqlString = "select * from day order by id desc limit 1";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlString);

		if (rs.next()) {
			id = rs.getInt("id");
			id = id - 6;
		}
		helper.closeConnection(con);
		return id;
	}

	// creeaza o saptamana

	public void addWeekDays(int weekId) throws SQLException {
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();
		DayOfTheWeek[] days = DayOfTheWeek.values();
		for (DayOfTheWeek day : days) {
			String sqlString = "insert into day (week_id, name)" + "values(?,?)";
			PreparedStatement ps = con.prepareStatement(sqlString);
			ps.setInt(1, weekId);
			ps.setString(2, day.toString());
			ps.executeUpdate();
		}
		helper.closeConnection(con);
	}

	// adauga o reteta pentru mic dejun/pranz/cina (1/2/3)
	public void addReceiptForAMeal(int type, int receiptId, int dayId) throws SQLException {
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String sqlString = "insert into day_receipts (type, receipt_id, day_id)" + "values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sqlString);
		ps.setInt(1, type);
		ps.setInt(2, receiptId);
		ps.setInt(3, dayId);
		ps.executeUpdate();

		helper.closeConnection(con);
	}

	// sterge o reteta pentru mic dejun/pranz/cina (1/2/3)
	public void deleteReceiptForAMeal(int type, int receiptId, int dayId) throws SQLException {
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String sqlString = "delete from day_receipts where type=? and receipt_id=? and day_id=?";
		PreparedStatement ps = con.prepareStatement(sqlString);
		ps.setInt(1, type);
		ps.setInt(2, receiptId);
		ps.setInt(3, dayId);
		ps.executeUpdate();

		helper.closeConnection(con);
	}

	// returneaza lista de retete pentru o masa(1/2/3) dintr-o zi (dayId)

	public ArrayList<Receipt> getReceiptsForAMeal(int type, int dayId) throws SQLException {
		ArrayList<Receipt> receiptList = new ArrayList<Receipt>();
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();
		String sqlString = "select * from day_receipts where type=? and day_id=?";
		PreparedStatement stmt = con.prepareStatement(sqlString);
		stmt.setInt(1, type);
		stmt.setInt(2, dayId);
		ResultSet rs = stmt.executeQuery();
		ReceiptDAO rdao = new ReceiptDAO();
		while (rs.next()) {
			int receiptId = rs.getInt("receipt_id");
			receiptList.add(rdao.findReceipt(receiptId));
		}
		helper.closeConnection(con);
		return receiptList;
	}

}
