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
		return (build) ? cf = new ConnectionFactory() : cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
/*		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@chinook.c8azt1nhtup5.us-east-2.rds.amazonaws.com:1521:ORCL";
		//jdbc:(driver):(url):port/ORCL
		String user = "chinook";
		String pass = "p4ssw0rd";*/
		Properties prop = new Properties();
		
		try {
			
			prop.load(new FileReader("C:\\Users\\aaron\\ProjectRepos\\1806-Jun18-Java-USF\\Aaron_Mathews_Code-Week2\\"
					+ "jdbc-demo\\src\\main\\resources\\application.properties"));
			
			Class.forName(prop.getProperty("driver"));
			
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("user"),
					prop.getProperty("pass"));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return conn;
	}

}
