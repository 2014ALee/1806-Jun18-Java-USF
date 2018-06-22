package com.revature.integrated.functions;

import com.revature.models.BankAccount;
import com.revature.utils.ConsoleHandler;
import com.revature.utils.UserFileHandler;

public class Login {
	// Functionality for the user to log in
	public static BankAccount login() {
		// Asks the user for username and password
		String username = ConsoleHandler.promptUser("Enter your username: ");
		username = username.toLowerCase();
		System.out.println("You entered " + username + " as your username.");
		String password = ConsoleHandler.promptUser("Enter your password: ");
		
		// Fetches the user information from file if user exists.
		UserFileHandler fh = new UserFileHandler(username);
		if (!fh.hasFile()) {
			return null;
		}
		String userData = fh.readFile();
		if (userData == null) {
			System.out.println("[LOG] System error in reading data");
			System.exit(0);;
		}
		
		// Once fetched, parse.
		BankAccount ba = null;
		try {
			ba = BankAccount.parseBankAccount(userData);
		} catch (NumberFormatException e) {
			System.out.println("Error reading from bank account.");
			System.exit(1);
		}
		
		/*
		 * If the bank information is available, check if the
		 * password works.
		 */
		if (ba.checkAuthentication(password)) {
			return ba;
		}
		else {
			return null;
		}
	}

}
