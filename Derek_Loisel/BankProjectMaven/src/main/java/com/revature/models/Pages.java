package com.revature.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pages {

	public static String mainMenu(BufferedReader br) {

		// string to store user input
		String userInput = "";

		System.out.println("\n-------------MAIN MENU-------------");

		System.out.println("[1] - Login");
		System.out.println("[2] - Register");
		System.out.println("[3] - Exit");
		System.out.print("Selection: ");

		try {
			// get user input from main menu
			userInput = br.readLine();

		} catch (IOException ioe) {
			// System.out.println("[LOG] - Error while reading from console");
			// e.printStackTrace();
			System.out.println("hi");

		}

		return userInput;
	}	



	public static User register(BufferedReader br, User user) {

		// Strings to store user input for User object
		String firstName, lastName, username, password, email;

		System.out.println("\n-----------REGISTRATION------------");

		try {

			// get user input to fill User object
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

			// create new User object
			user = new User(firstName, lastName, username, password, email);
			
		} catch (IOException ioe) {
			// System.out.println("[LOG] - Error while reading from console");
			// e.printStackTrace();
		}

		return user;
	}

	public static User login(BufferedReader br, User user) {

		System.out.println("\n---------------LOGIN---------------");

		try {

			System.out.print("Username: ");
			user.setUsername(br.readLine());

			System.out.print("Password: ");
			user.setPassword(br.readLine());

		} catch (IOException ioe) {
			// System.out.println("[LOG] - Error while reading from console");
			ioe.printStackTrace();
		}

		return user;
	}
	
	public static User homePage(BufferedReader br, User user) {
	
		
		
		return user;
	}
}
