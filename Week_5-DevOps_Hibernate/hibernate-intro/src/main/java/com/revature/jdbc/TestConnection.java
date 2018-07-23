package com.revature.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@hibernate-demo.c0nbqj7oncuf.us-east-1.rds.amazonaws.com:1521:ORCL";
		String user = "admin";
		String pass = "p4ssw0rd";
		
		try {
			
			System.out.println("Connecting to database: " + url);
			
			Connection conn = DriverManager.getConnection(url, user, pass);
			conn.close();
			
			System.out.println("Connection successful!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
