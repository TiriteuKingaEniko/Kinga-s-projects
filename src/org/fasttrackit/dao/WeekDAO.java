package org.fasttrackit.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.fasttrackit.helpers.DBhelpers;
import org.fasttrackit.pojo.Week;

public class WeekDAO {

	// adauga o saptamana noua

	public void addWeek(Week week) throws SQLException {
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String insertIngredient = "insert into week (user_id, name, start_date, end_date)" + "values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insertIngredient);

		ps.setInt(1, week.getUserId());
		ps.setString(2, week.getName());
		ps.setDate(3, (Date) week.getStartDate());
		ps.setDate(4, (Date) week.getEndDate());
		ps.executeUpdate();

		helper.closeConnection(con);

	}

	// returneaza o saptamana dupa ID

	public Week getWeek(int id) throws SQLException {
		Week week = null;
		DBhelpers helper = new DBhelpers();
		Connection con = helper.getConnection();

		String sqlString = "select * from week where id=?";
		PreparedStatement stmt = con.prepareStatement(sqlString);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			int userId = rs.getInt("user_id");
			String name = rs.getString("name");
			Date start = rs.getDate("start_date");
			Date end = rs.getDate("end_date");
			week = new Week(id, userId, name, start, end);
		}
		helper.closeConnection(con);
		return week;
	}

}
