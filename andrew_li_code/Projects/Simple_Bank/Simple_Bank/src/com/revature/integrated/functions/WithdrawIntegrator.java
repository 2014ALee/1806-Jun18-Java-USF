package com.revature.integrated.functions;

import com.revature.exceptions.NegativeAmountException;
import com.revature.models.BankAccount;
import com.revature.utils.UserFileHandler;

public class WithdrawIntegrator {
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
			UserFileHandler uf = new UserFileHandler(account.getUsername());
			if (uf.writeNewFile(account.toString())) {
				System.out.println("Successfully withdrawn " + amount);
				System.out.println("Balance is " + account.getBalance());
			}
			else { // if ther's a File Writing Error (IOException)
				System.out.println("There was an error updating your account.");
			}
		}
		else { // Explains that funds are insufficient.
			System.out.println("Insufficient funds.");
			System.out.println("Withdraw amount: " + amount);
			System.out.println("Balance is " + account.getBalance());
		}
	}
}
