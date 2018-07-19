package com.revature.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
	
	public static void main(String[] args) {
		
		String url = "****";
		String user = "****";
		String password = "****";
		
		try {
			
			System.out.println("Testing connection to database: " + url);
			
			Connection conn = DriverManager.getConnection(url, user, password);
			conn.close();
			
			System.out.println("Connection successfully established");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
