package com.revature.models;

import com.revature.exceptions.NegativeAmountException;
import com.revature.utils.StringHandler;
/*
 * Representation of a bank account.
 */
public class BankAccount {
	private String username;
	private String hashedPassword;
	private long pennies;
	
	public BankAccount(String username, String password) {
		this.username = username;
		this.hashedPassword = StringHandler.hash(password);
		this.pennies = 0;
	}
	
	public String getUsername() {
		return username;
	}
	
	public boolean checkAuthentication(String password) {
		return this.hashedPassword.equals(StringHandler.hash(password));
	}
	
	/*
	 * Return false if there's insufficient funds,
	 * return true if there are sufficient funds,
	 * and update the balance.
	 */
	public boolean withdraw(double amount) throws NegativeAmountException {
		if (amount < 0) {
			throw new NegativeAmountException();
		}
		
		long amountInPennies = Math.round(100 * amount);
		
		if (amountInPennies > this.pennies) {
			return false;
		}
		else {
			this.pennies -= amountInPennies;
			return true;
		}
	}
	/*
	 * Getting the balance.
	 */
	public String getBalance() {
		String output = "";
		if (this.pennies < 10) {
			output = "0.0" + pennies;
		} else if (this.pennies < 100) {
			output = "0." + pennies;
		}
		else {
			output += (this.pennies / 100) + "." + (this.pennies % 100);
		}
		return output;
	}
	
	public long getPennies() {
		return this.pennies;
	}
	
	/*
	 * Increase the balance when depositing.
	 */
	public boolean deposit(double amount) throws NegativeAmountException {
		if (amount < 0) {
			throw new NegativeAmountException();
		}
		else {
			this.pennies += Math.round(100 * amount);
			return true;
		}
	}

	@Override
	public String toString() {
		return "BankAccount [username=" + username + ", hashedPassword=" + hashedPassword + ", balance=" + this.getBalance()
				+ "]";
	}
}
