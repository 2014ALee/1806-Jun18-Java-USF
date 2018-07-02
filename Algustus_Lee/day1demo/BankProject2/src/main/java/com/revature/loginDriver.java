package com.revature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionFactory;

public class loginDriver extends menuDriver {
	public static String userName;
	public static String password;
	public static void login() {

		System.out.println("====================Enter Username=====================");
		System.out.print("User >");
		userName = input.nextLine();

		System.out.println("====================Enter Password=====================");
		System.out.print("User >");
		password = input.nextLine();

		if(validLogin(userName, password))
		{
			System.out.println("========================Logging In=========================");
			loggedInMenu(userName,password);
		}
		else
		{
			System.out.println("========================Invalid Login======================");
			mainMenu();
		}
	}
	private static boolean validLogin(String userName, String password) {
		System.out.println("=======================Establishing Connection=======================");
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection()){
			String sql = "SELECT * FROM ALL_USERS WHERE username = ? AND pass_word = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			int rowCount = 0;
			while(rs.next()) {
				rowCount++;
			}
			if(rowCount != 1){
				return false;
			}
			else {
				System.out.println("==================Connected==================");
				return true;
			}
		} catch (SQLException e) {
			System.out.println("exception "+e+" was seen here");
			e.printStackTrace();
		}
		System.out.println("everything was ignored.");
		return false;
	}

}
