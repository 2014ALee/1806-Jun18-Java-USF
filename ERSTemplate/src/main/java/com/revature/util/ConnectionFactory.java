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
		if(build) {
			return cf = new ConnectionFactory();
		} else {
			return cf;
		}

	}

	public Connection getConnection() {

		Connection con = null;
		Properties prop = new Properties();	

		try {

			prop.load(new FileReader("C:\\Users\\Tom Steyaert\\1806-Jun18-Java-USF\\EmployeeReimbursementSystem\\ERS.properties"));
			Class.forName(prop.getProperty("driver"));

			con = DriverManager.getConnection(
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

		return con;
	}

}
