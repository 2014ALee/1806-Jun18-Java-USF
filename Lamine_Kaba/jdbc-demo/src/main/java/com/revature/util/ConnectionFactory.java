package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static  ConnectionFactory cf;
	private static boolean build = true;
	
	private ConnectionFactory() {
		build = false;
	}
	
	public static synchronized ConnectionFactory getInstance() {
		return(build) ? cf = new ConnectionFactory() : cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url ="jdbc:oracle:thin:@chinook.cjiupc6li1sl.us-east-2.rds.amazonaws.com:1521:ORCL";
		String usr = "chinook";
		String pw = "p4ssw0rd";
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, usr, pw);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
