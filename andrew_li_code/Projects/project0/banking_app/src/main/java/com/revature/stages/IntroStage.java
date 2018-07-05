package com.revature.stages;

import com.revature.integrations.Login;
import com.revature.integrations.Register;
import com.revature.models.BankAccount;
import com.revature.utils.ConsoleHandler;
import com.revature.utils.StringHandler;

public class IntroStage {
	public static BankAccount intro() {
		boolean stageContinuing = true;
		while (stageContinuing) {
			// We prompt the user to select a command
			String userInput = ConsoleHandler.promptUser(
					"Select one of the following options. "
					+ "[log in] [create account] [exit]: ");
			// In case user makes reasonable mistakes...
			userInput = userInput.toLowerCase();
			userInput = StringHandler.fixCommand(userInput);
			
			switch (userInput) {
				case "log in": case "login": // Login
					BankAccount account = Login.login();
					if (account == null) {
						System.out.println("invalid username or password");
					}
					else {
						System.out.println("Logged in as " + account.getUsername());
						return account;
					}
					break;
				case "create account": case "register": // Registration
					Register.register();
					break;
				case "exit": case "cancel": // End this if you want to cancel. We can handle null.
					System.out.println("Exiting out of this program.");
					stageContinuing = false;
					break;
				default: // If the user inputs an invalid String.
					System.out.println("\n" + userInput + " is invalid input.\n");
			}
		}
		return null;
	}
}
