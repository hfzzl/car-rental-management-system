package com.crms.demo.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	public static Connection connectDB() {
		Connection conn = null;
		try {
			String dbURL = "jdbc:mysql://localhost:3306/CRMS";
			String username = "root";
			String password = "";
				
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL,username,password);
			System.out.println("db opened successfully at: " + conn.getMetaData());
		} 
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
}
