package com.revature;

import java.io.IOException;

import com.revature.models.*;
import com.revature.utils.*;

public class BankAccountDriver {

	public static void main(String[] args) {
		/*
		 * At this stage, the user has yet to log in
		 * the user has just started and is definitely
		 * not finished.
		 */
		boolean needToLogin = true;
		boolean notFinished = true;
		BankAccount ba = null;
		while (needToLogin && notFinished) {
			/*
			 * We prompt the user for one of these three
			 * commands.
			 */
			String userInput = ConsoleHandler.promptUser(
					"Select one of the following options. "
					+ "[log in] [create account] [cancel]: ");
			// In case user makes reasonable mistakes...
			userInput = userInput.toLowerCase();
			userInput = StringHandler.fixCommand(userInput);
			
			switch (userInput) {
				case "log in": case "login":
					BankAccount account = login();
					if (account == null) {
						System.out.println("invalid username or password");
					}
					else {
						ba = account;
						System.out.println("Logged in as " + account.getUsername());
						needToLogin = false;
					}
					break;
				case "create account": case "register":
					register();
					break;
				case "cancel":
					notFinished = false;
					System.out.println("Exiting out of this program.");
					break;
				default:
			}
		}
		while (notFinished) {
			String userInput = ConsoleHandler.promptUser(
					"Select one of the following options. "
					+ "[deposit] [withdraw] [check balance] [log out]: ");
			// In case user makes reasonable mistakes...
			userInput = userInput.toLowerCase();
			userInput = StringHandler.fixCommand(userInput);
			switch (userInput) {
				case "log out": case "logout":
					notFinished = false;
					System.out.println("Exiting out of this program.");
					break;
				case "deposit":
					double amount = ConsoleHandler.promptNumber(
							"Enter the amount to deposit: ");
					deposit(ba, amount);
					break;
				case "withdraw":
					double amount2 = ConsoleHandler.promptNumber(
							"Enter the amount to withdraw: ");
					withdraw(ba, amount2);
					break;
				case "check balance":
					System.out.println("The balance is :" + ba.getBalance());
					break;
				default:
		}
		}
		
	}
	/*
	 * Return the username if login was successful.
	 */
	public static BankAccount login() {
		/*
		 * Prompt the user for the username and password.
		 */
		String username = ConsoleHandler.promptUser("Enter your username: ");
		username = username.toLowerCase();
		System.out.println("You entered " + username + " as your username.");
		String password = ConsoleHandler.promptUser("Enter your password: ");
		
		/*
		 * Fetch information from file.
		 */
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
	private static void register() {
		/*
		 * Prompt the user for the username and password.
		 */
		String username = ConsoleHandler.promptUser("Enter the username that you will register for: ");
		username = username.toLowerCase();
		System.out.println("You entered " + username + " as your username.");
		UserFileHandler uf = new UserFileHandler(username);
		/*
		 * Check if username already exists.
		 */
		boolean createFile = false;
		try {
			createFile = uf.createFile();
		}
		catch (IOException e) {
			System.out.println("Error in file creation.");
			return;
		}
		if (!createFile) {
			System.out.println("Username is unavailable.");
			return;
		}
		// BankAccount class already hashes the password.
		String password = ConsoleHandler.promptUser("Enter your password: ");
		BankAccount ba = new BankAccount(username, password);
		if (uf.writeNewFile(ba.toString())) {
			System.out.println("Registration successful.");
		} else {
			System.out.println("Failed to register.");
		}
	}
	public static void deposit(BankAccount account, double amount) {
		account.deposit(amount);
		UserFileHandler uf = new UserFileHandler(account.getUsername());
		uf.writeNewFile(account.toString());
	}
	public static void withdraw(BankAccount account, double amount) {
		if (account.withdraw(amount)) {
			System.out.println("Successfully withdrawn " + amount);
			System.out.println("Balance is " + account.getBalance());
		}
		else {
			System.out.println("Insufficient funds.");
			System.out.println("Withdraw amount: " + amount);
			System.out.println("Balance is " + account.getBalance());
		}
	}
}
