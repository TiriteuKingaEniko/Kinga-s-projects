package org.fasttrackit.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBhelpers {
	public Connection getConnection() {

		Properties connectionProps = new Properties();
		connectionProps.put("user", "root");
		connectionProps.put("password", "Kinga");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/receipt_book", connectionProps);
		}

		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
