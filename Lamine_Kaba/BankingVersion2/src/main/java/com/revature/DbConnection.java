package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;




public class DbConnection {
	
	public static void main(String[] args) {
		
		getConnect();
		
	}
	
public static Connection getConnect() {
		
		Connection con = null;
		
		String driver ="oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@bankingapp.cjiupc6li1sl.us-east-2.rds.amazonaws.com:1521:ORCL";
		String username = "lkaba";
		String password = "kaquev11";
		
		try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, username, password);
				System.out.println("Connected");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
}
