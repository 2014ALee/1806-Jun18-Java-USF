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

	private ConnectionFactory() {
		build = false;
	}

	public static synchronized ConnectionFactory getInstance() {
		return (build) ? cf = new ConnectionFactory(): cf;
	}
	
	public Connection getConnection() {
		
		Connection conn = null;
		
		Properties prop = new Properties();
	
		try {
			
			//load in values from properties file
			prop.load(new FileReader("D:\\batch-repos\\1806-Jun18-Java-USF\\Derek_Loisel_week4\\Project1\\src\\main\\resources\\application.properties"));
			
			//gets class path to load and register the oracle driver
			Class.forName(prop.getProperty("driver"));	
			
			//establish connection
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
