package com.revature.models;

public class Account {
	
	private int accountID;
	private String accountName;
	private double balance;
	private boolean frozen;
	
	public Account() {}

	public Account(int accountID, String accountName, double balance, boolean frozen) {
		super();
		this.accountID = accountID;
		this.accountName = accountName;
		this.balance = balance;
		this.frozen = frozen;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isFrozen() {
		return frozen;
	}

	public void setFrozen(boolean frozen) {
		this.frozen = frozen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountID;
		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (frozen ? 1231 : 1237);
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
		if (accountName == null) {
			if (other.accountName != null)
				return false;
		} else if (!accountName.equals(other.accountName))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (frozen != other.frozen)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", accountName=" + accountName + ", balance=" + balance + ", frozen="
				+ frozen + "]";
	}
	
	

}
