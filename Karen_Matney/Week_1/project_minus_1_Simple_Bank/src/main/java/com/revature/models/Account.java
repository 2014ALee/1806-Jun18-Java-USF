/*
 * Karen Matney
 * June 24, 2018
 * Account.java
 * Project -1 Revature Training
 * A class that holds the minimal account information for the SimpleBank class.
 * Intended for updating and viewing the balance
 */
package com.revature.models;

import java.io.Serializable;

public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	private int accountNumber;
	private double balance;
	
	public Account() { }
	
	public Account(int accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	// Replaced the default setter with balance with two methods that are more specific
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public void withdrawl(double amount) {
		this.balance -= amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + "]";
	}
}
