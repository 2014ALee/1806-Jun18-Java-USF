package com.revature.integrated.functions;

import com.revature.exceptions.NegativeAmountException;
import com.revature.models.BankAccount;
import com.revature.utils.UserFileHandler;

public class DepositIntegrator {
	public static void deposit(BankAccount account, double amount) {
		// Handles the problem when user inputs negative amount.
		try {
			account.deposit(amount);
		} catch (NegativeAmountException e) {
			System.out.println("Cannot deposit a negative amount.");
			System.out.println("You can use the withdraw option instead.");
			return;
		}
		// Communicates with the File handler, see FileHandler.java for details.
		UserFileHandler uf = new UserFileHandler(account.getUsername());
		if (uf.writeNewFile(account.toString())) {
			System.out.println("Successfully deposited " + amount);
			System.out.println("Balance is " + account.getBalance());
		}
		else { // Unexpected IOError from writing to file.
			System.out.println("[LOG] There was an error updating your account.");
		}
	}
}
