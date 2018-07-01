package com.revature.models;

public class Account {

	private int accountID;
	private double checkingBalance;
	private double savingsBalance;
	
	public Account() {};
	
	public Account(int accountID, double checkingBalance, double savingsBalance) {
		super();
		this.accountID = accountID;
		this.checkingBalance = checkingBalance;
		this.savingsBalance = savingsBalance;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountID;
		long temp;
		temp = Double.doubleToLongBits(checkingBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(savingsBalance);
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
		if (accountID != other.accountID)
			return false;
		if (Double.doubleToLongBits(checkingBalance) != Double.doubleToLongBits(other.checkingBalance))
			return false;
		if (Double.doubleToLongBits(savingsBalance) != Double.doubleToLongBits(other.savingsBalance))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", checkingBalance=" + checkingBalance + ", savingsBalance="
				+ savingsBalance + "]";
	}
	
	
}
