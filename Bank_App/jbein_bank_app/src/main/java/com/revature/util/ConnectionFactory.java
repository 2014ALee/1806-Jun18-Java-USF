package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	private static ConnectionFactory cf;
	private static boolean build = true;
	
	// create private instance because this is a singleton design pattern
	private ConnectionFactory() {
		build = false;
	}

	public static synchronized ConnectionFactory getInstance() {
		// if build is false, return a new connection factory, 
		// if true, return our current ConnectionFactory
		return (build) ? cf = new ConnectionFactory() : cf;
	}
	
	public Connection getConnection() {
		
		Connection conn = null;
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader("C:\\Users\\jbein\\Project-Repos\\1806-Jun18-Java-USF\\Bank_App\\jbein_bank_app"
					+ "\\src\\main\\resources\\application.properties"));
			
			// load the driver
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(
					prop.getProperty("url"), 
					prop.getProperty("usr"), 
					prop.getProperty("pw"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
