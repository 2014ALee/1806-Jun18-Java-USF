package com.revature.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnectionFactory {

	public static void main(String[] args) {
		ConnectionFactory myConnection = ConnectionFactory.getInstance();
		Connection connection = myConnection.getConnection();
		try {
			connection.close();
			System.out.println("Successful close");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(BasicHelpers.hash("password"));
	}
}
