package com.activities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class Register {

	static Scanner userInput = new Scanner(System.in);
	static User user = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void register() {

		String firstName, lastName, username, password, email;

		System.out.println("\n    +--------------REGISTRATION--------------+");


		try {

			System.out.print("First name: ");
			firstName = br.readLine();

			System.out.print("Last name: ");
			lastName = br.readLine();

			System.out.print("Username: ");
			username = br.readLine();

			System.out.print("Password: ");
			password = br.readLine();

			System.out.print("Email Address: ");
			email = br.readLine();
			
			
			user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setUsername(username);
			user.setEmail(email);
			user.setPassword(password);


			UserDAO userDAO = new UserDAOImpl();
			//user = userDAO.addUser(user);
			
			
			
			try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
				user = new User();
				user.setUsername(username);
				//				System.out.println(user.getUsername());
				System.out.println("Checking username availability..." );
				System.out.println("from register username is ------->> " + user.getUserId());

				if(HelperMethods.usernameAvailable(user)) {

					System.out.println("Creating new user, " + user.getUsername() + "...\n");
					System.out.println("Username " + user.getUsername() + " Created successfully!");
					
					user = userDAO.addUser(user);
					
					Login.login();
				} else {
					System.out.println("Username is not available. Please try again...");
					register();
				}

			}catch(SQLException e) {
				e.printStackTrace();
			}

			

			
//			try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
//				user = new User();
//				user.setUsername(username);
//				//				System.out.println(user.getUsername());
//				System.out.println("Checking username availability..." );
//				System.out.println("from register username is ------->> " + user.getUserId());
//
//				if(HelperMethods.usernameAvailable(user)) {
//
//					System.out.println("Creating new user, " + user.getUsername() + "...\n");
//					System.out.println("Username " + user.getUsername() + " Created successfully!");
//					String query = "INSERT INTO allUsers(first_name,last_name,username,password,email) values(?,?,?,?,?)";
//					
//					String[] keys = new String[1];
//					keys[0] = "user_id";
//
//					PreparedStatement pst = conn.prepareStatement(query);
//
//					pst.setString(1, firstName);
//					pst.setString(2, lastName);
//					pst.setString(3, username);
//					pst.setString(4, password);
//					pst.setString(5, email);
//
//					pst.executeUpdate();
//					
//					ResultSet rs = pst.getGeneratedKeys();
//					
//					if(rowUpdated != 0) {
//						 while(rs.next()) {
//							 newUsers.setUserId(rs.getInt(1));
//						 }
//						 }
//						 newUsers.setUsername(newUser.getUsername());
//						 newUsers.setLastName(newUser.getLastName());
//						 newUsers.setFirstName(newUser.getFirstName());
//						 newUsers.setPassword(newUser.getPassword());
//						 newUsers.setEmail(newUser.getEmail());
//					Login.login();
//				} else {
//					System.out.println("Username is not available. Please try again...");
//					register();
//				}
//
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//
		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from console");
			e.printStackTrace();
		}

	}
	
}
