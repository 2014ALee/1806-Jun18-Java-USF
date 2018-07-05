package com.revature.integrations;

import com.revature.dao.BankUserDAO;
import com.revature.dao.BankUserDAOImplementation;
import com.revature.models.BankAccount;
import com.revature.utils.ConsoleHandler;

public class Login {
	// Functionality for the user to log in
	public static BankAccount login() {
		// Asks the user for username and password
		String username = ConsoleHandler.promptUser("Enter your username: ");
		username = username.toLowerCase();
		System.out.println("You entered " + username + " as your username.");
		String password = ConsoleHandler.promptUser("Enter your password: ");
		
		// Fetches the account with the entered username
		BankUserDAO bud = new BankUserDAOImplementation();
		BankAccount bacc = bud.getBankUserByUsername(username);
		
		// Check if the password matches.
		if (bacc != null && bacc.checkAuthentication(password)) {
			return bacc;
		} else {
			return null;
		}
	}
}
