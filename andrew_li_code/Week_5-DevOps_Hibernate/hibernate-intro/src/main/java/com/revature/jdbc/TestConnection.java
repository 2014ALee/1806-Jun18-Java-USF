package com.revature.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {
		try {
			DriverManager.getConnection("jdbc:oracle:thin:@hibernate-demo.cpbpkfz3ozbv.us-east-1.rds.amazonaws.com:1521:ORCL", "admin", "Iw2kRR1d!");
			System.out.println("Works");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
