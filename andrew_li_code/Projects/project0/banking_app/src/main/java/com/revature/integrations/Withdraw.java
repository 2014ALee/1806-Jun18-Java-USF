package com.revature.integrations;

import com.revature.dao.BankUserDAO;
import com.revature.dao.BankUserDAOImplementation;
import com.revature.exceptions.NegativeAmountException;
import com.revature.models.BankAccount;
import com.revature.utils.StringHandler;

public class Withdraw {
	public static void withdraw(BankAccount account, double amount) {
		boolean withdrawn = false;
		// Takes care of negative inputs from user.
		try {
			withdrawn = account.withdraw(amount);
		} catch (NegativeAmountException e) {
			System.out.println("Cannot withdraw a negative amount.");
			System.out.println("Use the deposit option instead.");
			return;
		}
		// Evaluates to true unless user inputs a higher value than balance.
		// See BankAccount.java for more details.
		if (withdrawn) {
			BankUserDAO bud = new BankUserDAOImplementation();
			if (bud.updateBankUserBalance(account)) {
				System.out.println("Successfully withdrawn. Withdraw amount: "
						+ StringHandler.amountToString(amount));
				System.out.println("Balance is " + account.getBalance());
			}
			else {
				System.out.println("Database error in updating your balance.");
				// if the update failed, reverse the transaction.
				// Compiler requires the try catch even though we already
				// know the amount wasn't negative since it reached this point.
				try { account.deposit(amount); }
				catch (NegativeAmountException e) {}
			}
		}
		else { // Explains that funds are insufficient.
			System.out.println("Insufficient funds.");
			System.out.println("Withdraw amount: "
					+ StringHandler.amountToString(amount));
			System.out.println("      Balance is " + account.getBalance());
		}
	}
}
