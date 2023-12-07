package com.jbk.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Config {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webcompany", "root", "7777");
		} catch (Exception e) {
			System.out.println("Connection Problem Occured..");
		}
		return con;
	}

}
