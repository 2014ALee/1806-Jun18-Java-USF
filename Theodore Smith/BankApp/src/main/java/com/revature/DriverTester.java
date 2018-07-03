package com.revature;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class DriverTester {
	
	
  public static void main(String[] args) {
	  
	System.out.println("-------- JDBC Connection Testing ------------");

	System.out.println("MySQL JDBC Driver Registered!");
	Connection connection = null;
	try {
		connection = DriverManager
		.getConnection("bank.cjv8rav3fvzw.us-east-1.rds.amazonaws.com");
	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;
	}
	if (connection != null) {
		System.out.println("You made it, take control your database now!");
	} else {
		System.out.println("Failed to make connection!");
	}
  }
}