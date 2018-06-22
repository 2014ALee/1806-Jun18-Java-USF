package com.revature.models;

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
		parsed.hashedPassword = stringRepr.substring(
				stringRepr.indexOf("hashedPassword=") + 15,
				stringRepr.indexOf(", "));
		stringRepr = stringRepr.substring(
				stringRepr.indexOf(", ") + 2, stringRepr.length());
		
		// Parsing out the balance.
		parsed.balance = Double.parseDouble(stringRepr.substring(
				stringRepr.indexOf("balance=") + 8,
				stringRepr.indexOf("]")));
		return parsed;
	}
	
	/*
	 * Return false if there's insufficient funds,
	 * return true if there are sufficient funds,
	 * and update the balance.
	 */
	public boolean withdraw(double amount) {
		if (amount > this.balance) {
			return false;
		}
		else {
			this.balance -= amount;
			return true;
		}
	}
	/*
	 * Getting the balance.
	 */
	public double getBalance() {
		return balance;
	}
	
	/*
	 * Increase the balance when depositing.
	 */
	public void deposit(double amount) {
		balance += amount;
	}

	@Override
	public String toString() {
		return "BankAccount [username=" + username + ", hashedPassword=" + hashedPassword + ", balance=" + balance
				+ "]";
	}
}
