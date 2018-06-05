package com.smartekprog.connect;

import java.sql.*;

public class jdbcconnect {

	
	public Statement connect() {
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydata", "root", "root");
			st = con.createStatement();
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
		return st;
	}
	
	public Connection getconnection() {
		PreparedStatement pst;
		Connection con = null ;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydata", "root", "root");
			return con;
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
		return con;
	}
	
}
