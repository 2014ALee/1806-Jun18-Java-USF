package com.revture.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
	public static void main(String[] args) {
		String url = "";
		String user = "";
		String pass = "";
		
		try {
			System.out.println("Testing connection to database: " + url);
			
			Connection conn = DriverManager.getConnection(url,user,pass);
			conn.close();
			
			System.out.println("established");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
