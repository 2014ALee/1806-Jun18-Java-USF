package com.revature.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
	public static void main(String[] args) {
		//String driver = "oracle.jdbc.driver.OracleDriver";
		String url ="jdbc:oracle:thin:@revature-7-19-2018-demo.cbgnxfydyd2b.us-east-2.rds.amazonaws.com:1521:ORCL";
		String user ="Algustus_Lee";
		String pass ="password";
		
		try {
			System.out.println("Testing Connection to the database");
			//Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, pass);
			conn.close();
			System.out.println("Connection established.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
