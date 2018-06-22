package com.revature.integrated.functions;

import java.io.IOException;

import com.revature.models.BankAccount;
import com.revature.utils.ConsoleHandler;
import com.revature.utils.UserFileHandler;

public class Register {
	public static void register() {
		// Asks user for a username to register.
		String username = ConsoleHandler.promptUser("Enter the username that you will register for: ");
		username = username.toLowerCase();
		System.out.println("You entered " + username + " as your username.");
		UserFileHandler uf = new UserFileHandler(username);
		
		// Check if username is available.
		boolean createFile = false;
		try {
			createFile = uf.createFile();
		}
		catch (IOException e) { // This is usually caused by outside corruption
			System.out.println("Error in file creation.");
			return;
		}
		if (!createFile) { // Occurs if user exists. See UserFileHandler fpr details.
			System.out.println("Username is unavailable.");
			return;
		}
		// Password comparison
		String password = ConsoleHandler.promptUser("Enter your password: ");
		BankAccount ba = new BankAccount(username, password);
		if (uf.writeNewFile(ba.toString())) { // evaluates true if no unexpected IOException
			System.out.println("Registration successful.");
		} else {
			System.out.println("Failed to register.");
		}
	}

}
