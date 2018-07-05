package com.revature.stages;

import com.revature.integrations.Deposit;
import com.revature.integrations.Withdraw;
import com.revature.models.BankAccount;
import com.revature.utils.ConsoleHandler;
import com.revature.utils.StringHandler;

public class SessionStage {
	public static void session(BankAccount ba) {
		boolean notFinished = true; // Loop repeats until logout
		while (notFinished) {
			String userInput = ConsoleHandler.promptUser(
					"Select one of the following options. "
					+ "[deposit] [withdraw] [check balance] [log out]: ");
			// In case user makes reasonable mistakes...
			userInput = userInput.toLowerCase();
			userInput = StringHandler.fixCommand(userInput);
			switch (userInput) { // Exit out of the loop if user wants to log out.
				case "log out": case "logout":
					notFinished = false;
					System.out.println("Logging out and returning to main menu.");
					break;
				case "deposit":
					double amount = ConsoleHandler.promptNumber(
							"Enter the amount to deposit: ");
					Deposit.deposit(ba, amount);
					break;
				case "withdraw":
					double amount2 = ConsoleHandler.promptNumber(
							"Enter the amount to withdraw: ");
					Withdraw.withdraw(ba, amount2);
					break;
				case "check balance":
					System.out.println("The balance is: " + ba.getBalance());
					break;
				default:
			}
		}
	}
}
