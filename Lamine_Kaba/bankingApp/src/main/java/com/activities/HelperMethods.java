package com.activities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Scanner;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class HelperMethods {

	static Scanner userInput = new Scanner(System.in);
	static UserHelper userhelper = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	//Logout after logged in
	
	public static void logout() {
		System.out.println("Thank you for your business!\nGoodbye!!");
		System.exit(0);
	}
	
	//Exit the the program before logged in

	public static void exitProgram() {
		System.out.println("Thank you for visiting!\nGoodbye!!");
		System.exit(0);
	}
	
	//Trim user input to two decimal place

	public static double trimedUserInput(double userInput) {

		double receivedInput = userInput;

		// Trim input to 2 decimal place string
		String trimedInput;
		trimedInput = new DecimalFormat("#.00").format(receivedInput);

		// Parse the trimed value back to double
		double parsedDouble;
		parsedDouble = Double.parseDouble(trimedInput);

		return parsedDouble;
	}
	
	// the the balance to user in two decimal place

	public static String showAmount() {

		return  new DecimalFormat("#.00").format(userhelper.getBalance());
	}

	// Check user name availability before saving user info to the database
	
	public static boolean usernameAvailable(User user) {

		ArrayList<String> username = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "Select username From allusers";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				username.add(rs.getString("username"));
			}

			if(username.contains(user.getUsername()))
				return false;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static boolean credentialsValidation(String username, String password) {
		
		ArrayList<String> loginUsername = new ArrayList<>();
		ArrayList<String> loginPassword = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "Select username, password From allusers";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				loginUsername.add(rs.getString("username"));
				loginPassword.add(rs.getString("password"));
			}

			if(loginUsername.contains(username)  & loginPassword.contains(password))
				return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
				
		return false;
		
	}

}














