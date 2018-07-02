package com.revature.models;

import com.revature.exceptions.NegativeAmountException;
import com.revature.utils.StringHandler;
/*
 * Representation of a bank account.
 */
public class BankAccount {
	private String username;
	private String hashedPassword;
	private double balance;
	
	private BankAccount() {}
	
	public BankAccount(String username, String password) {
		this.username = username;
		this.hashedPassword = StringHandler.hash(password);
		this.balance = 0;
	}
	
	public String getUsername() {
		return username;
	}
	
	public boolean checkAuthentication(String password) {
		return this.hashedPassword.equals(StringHandler.hash(password));
	}
	// Attempt to reverse the toString() method.
	public static BankAccount parseBankAccount(String stringRepr) {
		BankAccount parsed = new BankAccount();
		// Username is alphanumeric, so no worries about
		// having a comma in it.
		

		// Parsing out the username first
		parsed.username = stringRepr.substring(
				stringRepr.indexOf("username=") + 9,
				stringRepr.indexOf(", "));
		stringRepr = stringRepr.substring(
				stringRepr.indexOf(", ") + 2, stringRepr.length());
		
		// Parsing out the hashed password next
		stringRepr = stringRepr.substring(
				stringRepr.lastIndexOf("hashedPassword=") + 15,
				stringRepr.length());
		parsed.hashedPassword = stringRepr.substring(0,
				stringRepr.indexOf(", "));
		stringRepr = stringRepr.substring(
				stringRepr.indexOf(", ") + 2, stringRepr.length());
		
		// Parsing out the balance.
		parsed.balance = Double.parseDouble(stringRepr.substring(
				stringRepr.indexOf("balance=") + 8,
				stringRepr.indexOf("]")));
		parsed.balance = Math.round(parsed.balance * 100) / 100.0;;
		parsed.balance += 0.001;
		return parsed;
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
		
		long pennies = (long) (100 * amount);
		amount = pennies / 100.0;
		
		if (pennies > Math.round(100 * this.balance)) {
			return false;
		}
		else {
			this.balance -= amount;
			this.balance = Math.round(this.balance * 100) / 100.0;
			this.balance += 0.001;
			return true;
		}
	}
	/*
	 * Getting the balance.
	 */
	public String getBalance() {
		String output = "" + this.balance;
		int decimalPlace = output.indexOf('.');
		int placement = decimalPlace - output.length();
		if (placement == -1) {
			output += "00";
		}
		else if (placement == -2) {
			output += "0";
		} else if (placement < -3 && decimalPlace >= 0) {
			return output.substring(0, decimalPlace + 3);
		}
		return output;
	}
	
	/*
	 * Increase the balance when depositing.
	 */
	public boolean deposit(double amount) throws NegativeAmountException {
		if (amount < 0) {
			throw new NegativeAmountException();
		}
		else {
			this.balance += amount;
			this.balance = Math.round(this.balance * 100) / 100.0;
			this.balance += 0.001;
			return true;
		}
	}

	@Override
	public String toString() {
		return "BankAccount [username=" + username + ", hashedPassword=" + hashedPassword + ", balance=" + this.getBalance()
				+ "]";
	}
}
