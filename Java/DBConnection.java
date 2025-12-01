package com.mphasis.TAX_CALULATION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/taxdb";
	private static final String DB_USER_NAME = "root";
	private static final String DB_PASSWORD = "root@39";

	private static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
	}

	public static boolean login(String username, String password) {
		String query = "SELECT * FROM Users WHERE Username=? AND Password=?";
		try (Connection conn = getConnection()) {
			PreparedStatement pst = conn.prepareStatement(query); // Since we using Pre-compiled sql statement we are
																	// using PreparedStatement
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			return rs.next();

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
