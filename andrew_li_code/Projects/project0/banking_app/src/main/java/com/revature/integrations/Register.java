package com.revature.integrations;

import com.revature.dao.BankUserDAO;
import com.revature.dao.BankUserDAOImplementation;
import com.revature.utils.ConsoleHandler;
import com.revature.utils.StringHandler;

public class Register {
	public static void register() {
		/*
		 * Getting the username that user wants to register.
		 */
		String username = ConsoleHandler.promptUser("Enter the username that you will register for: ");
		username = username.toLowerCase();
		System.out.println("You entered " + username + " as your username.");
		// If the username typed in an invalid username
		while (!StringHandler.isAlphaNumeric(username)) {
			username = ConsoleHandler.promptUser("\n\nAlphanumeric characters only. "
					+ " Please type in a "
					+ "valid username: ");
		}
		
		// Check if username is available.
		BankUserDAO bud = new BankUserDAOImplementation();
		boolean exists = bud.getBankUserByUsername(username) != null;
		if (exists) {
			System.out.println("An account with the username of "
					+ username + " already exists.");
			return;
		}
		// Getting the password from the user.
		String password = ConsoleHandler.promptUser("Enter your password: ");
		
		// Prints whether or not the registration was successful.
		if (bud.addBankUser(username, password)) { 
			System.out.println("Registration successful.");
		} else {
			System.out.println("An unexpected error occured while "
					+ "registering an account.");
		}
	}

}
