package com.revature.models;

import java.io.BufferedReader;
import java.io.IOException;

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
			ioe.printStackTrace();
		}

		return userInput;
	}

	public static User registerPage(BufferedReader br, User user) {

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

			// fill in user object
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			//user = new User(firstName, lastName, username, password, email);

		} catch (IOException ioe) {
			// System.out.println("[LOG] - Error while reading from console");
			// e.printStackTrace();
		}

		// check username availability
		if (Validate.usernameAvailable(user)) {
			// username available
			user.setInputValid(true);
			// break;
		} else {
			System.out.println("Username is not available. Please try again...");
			user.setInputValid(false);
		}

		return user;
	}

	public static User loginPage(BufferedReader br, User user) {

		System.out.println("\n---------------LOGIN---------------");

		String username = "";
		String password = "";

		try {

			System.out.print("Username: ");
			username = (br.readLine());

			System.out.print("Password: ");
			password = (br.readLine());

		} catch (IOException ioe) {
			// System.out.println("[LOG] - Error while reading from console");
			ioe.printStackTrace();
		}

		// check if the user from login are valid
		if (Validate.credentialsValid(username, password, user)) {
			// login successful
			// go to home page after successful login
			user.setInputValid(true);
			// break;
		} else {
			System.out.println("Login failed!\n");
			user.setInputValid(false);
		}

		return user;
	}

	public static String homePage(BufferedReader br, User user) {

		// string to store user input
		String userInput = "";
		
		System.out.println("\n-------------HOME PAGE-------------");
		System.out.println("[1] - Deposit");
		System.out.println("[2] - Withdraw");
		System.out.println("[3] - View Balance");
		System.out.println("[4] - Logout");
		System.out.print("Selection: ");

		try {
			// get user input from home page
			userInput = br.readLine();
		} catch (IOException ioe) {
			System.out.println("An error occured with your selection");
			ioe.printStackTrace();
		}

		return userInput;
	}



}
