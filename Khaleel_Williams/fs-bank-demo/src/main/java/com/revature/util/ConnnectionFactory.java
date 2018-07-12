package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnnectionFactory {
	
	private static ConnnectionFactory cf = null;
	private static boolean build = true;
	
	private ConnnectionFactory() {
		build = false;
	}
	
	public static synchronized ConnnectionFactory getInstance() {
		return (build) ? cf = new ConnnectionFactory() : cf;
	}
	
	public Connection getConnection() {
		
		Connection conn = null;
		Properties prop = new Properties();
		
		
			try {
				prop.load(new FileReader("C:\\Users\\Cry\\project-repos\\1806-Jun18-Java-USF\\"
						+ "Khaleel_Williams\\fs-bank-demo\\src\\main\\resources\\application.properties"));
				Class.forName(prop.getProperty("driver"));
				
				conn = DriverManager.getConnection(
						prop.getProperty("url"), 
						prop.getProperty("usr"),
						prop.getProperty("pw"));
				
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
