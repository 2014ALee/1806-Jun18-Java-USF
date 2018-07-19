package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MakeConnection {
	
	private static MakeConnection makeconnection;
	private static boolean bool = true;
	
	private MakeConnection() {
		bool = false;
	}

	public static MakeConnection getConnectionInstance() {
		
		return (bool) ? makeconnection = new MakeConnection() : makeconnection;
	}
	
	public Connection createConnection() {
		
		Connection conn = null;
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader("C:\\Users\\Cry\\project-repos\\1806-Jun18-Java-USF\\"
					+ "Khaleel_Williams\\Week_4\\Reimbursement\\src\\main\\resources\\application.properties"));
			
			
			Class.forName(prop.getProperty("driver"));//CLASS not found EXCEPTION
																						//adminUsr                  adminPw
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("pw"));//SQL EXCEPTION
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
