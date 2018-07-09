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

	public static synchronized ConnectionFactory getInstanceMethod() {
		return (build) ? cf = new ConnectionFactory():cf;
	}

	public Connection getConnection() {

		Connection conn = null;
		Properties prop = new Properties();

		try {
			prop.load(new FileReader("C:\\Users\\AlgustusLee-Laptop\\project-repos\\1806-Jun18-Java-USF"+
					"\\AlgustusLee Project1\\AleeProject1\\src\\main\\resources\\project1.properties"));
			conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("usr"),prop.getProperty("pw"));
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
