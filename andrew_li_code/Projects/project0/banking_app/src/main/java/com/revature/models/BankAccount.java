package com.revature.models;

import com.revature.exceptions.NegativeAmountException;
import com.revature.utils.StringHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Representation of a bank account.
 */
public class BankAccount {
	private int id;
	private String username;
	private String hashedPassword;
	private long pennies;
	
	public BankAccount(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.hashedPassword = StringHandler.hash(password);
		this.pennies = 0;
	}

	/*
	 * Functionality to translate a Result Set into an object.
	 * We don't want to allow a BankAccount object to be created
	 * using the hashed password unless it's from the database
	 * itself.
	 */
	private BankAccount() {}
	public static BankAccount fromDB(ResultSet rs) throws SQLException {
		BankAccount ourBankAccount = new BankAccount();
		ourBankAccount.id = rs.getInt("BankUserId");
		ourBankAccount.username = rs.getString("Username");
		ourBankAccount.hashedPassword = rs.getString("HashedPassword");
		ourBankAccount.pennies = rs.getLong("NumPennies");
		return ourBankAccount;
	}
	
	public String getUsername() {
		return username;
	}
	
	public int getId() {
		return this.id;
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
			output = "0.0" + this.pennies;
		} else if (this.pennies < 100) {
			output = "0." + this.pennies;
		}
		else {
			output += (this.pennies / 100);
			int afterDec = (int) (this.pennies % 100);
			if (afterDec < 10) {
				output += ".0";
			}
			else {
				output += ".";
			}
			output += afterDec;
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
		long newBalance = this.pennies + Math.round(100 * amount);
		if (newBalance < 0) {
			return false;
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
