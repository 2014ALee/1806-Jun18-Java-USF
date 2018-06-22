package com.revature.stages;

import com.revature.integrated.functions.DepositIntegrator;
import com.revature.integrated.functions.WithdrawIntegrator;
import com.revature.models.BankAccount;
import com.revature.utils.ConsoleHandler;
import com.revature.utils.StringHandler;

public class SecondStage {
	public static void handleSession(BankAccount ba) {
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
					System.out.println("Exiting out of this program.");
					break;
				case "deposit":
					double amount = ConsoleHandler.promptNumber(
							"Enter the amount to deposit: ");
					DepositIntegrator.deposit(ba, amount);
					break;
				case "withdraw":
					double amount2 = ConsoleHandler.promptNumber(
							"Enter the amount to withdraw: ");
					WithdrawIntegrator.withdraw(ba, amount2);
					break;
				case "check balance":
					System.out.println("The balance is: " + ba.getBalance());
					break;
				default:
			}
		}
		
	}
}