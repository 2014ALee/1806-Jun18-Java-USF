package com.revature.integrations;

import com.revature.dao.BankUserDAO;
import com.revature.dao.BankUserDAOImplementation;
import com.revature.exceptions.NegativeAmountException;
import com.revature.models.BankAccount;
import com.revature.utils.StringHandler;

public class Deposit {
	public static void deposit(BankAccount account, double amount) {
		// Handles the problem when user inputs negative amount.
		try {
			account.deposit(amount);
		} catch (NegativeAmountException e) {
			System.out.println("Cannot deposit a negative amount.");
			System.out.println("You can use the withdraw option instead.");
			return;
		}
		
		BankUserDAO bud = new BankUserDAOImplementation();
		if (bud.updateBankUserBalance(account)) {
			System.out.println("Successfully deposited. Deposit amount: "
					+ StringHandler.amountToString(amount));
			System.out.println("Balance is " + account.getBalance());
		}
		else {
			System.out.println("Database error in updating your balance.");
			// if the update failed, reverse the transaction.
			// Compiler requires the try catch even though we already
			// know the amount wasn't negative since it reached this point.
			// We also know it won't take out more than what's in since
			// we added the same amount beforehand.
			try { account.withdraw(amount); }
			catch (NegativeAmountException e) {}
		}
	}
}
