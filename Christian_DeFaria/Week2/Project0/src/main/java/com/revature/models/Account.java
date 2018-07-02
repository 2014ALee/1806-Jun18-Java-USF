package com.revature.models;

public class Account {
	
	private boolean checking;
	private int accountId;
	private double balance;
	
	public Account() { }

	public Account(boolean checking, int accountId, double balance) {
		super();
		this.checking = checking;
		this.accountId = accountId;
		this.balance = balance;
	}

	public boolean isChecking() {
		return checking;
	}

	public void setChecking(boolean checking) {
		this.checking = checking;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (checking ? 1231 : 1237);
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
		if (accountId != other.accountId)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (checking != other.checking)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [checking=" + checking + ", accountId=" + accountId + ", balance=" + balance + "]";
	}

}
