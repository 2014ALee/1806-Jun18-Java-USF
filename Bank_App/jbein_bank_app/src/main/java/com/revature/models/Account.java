package com.revature.models;

public class Account {

	private int account_id;
	private int cust_id;
	private int accountNumber;
	private double balance;
	private String accountType;
	
	public Account() {}

	public Account(int user_id, int accountNumber, double balance, String accountType) {
		super();
		this.cust_id = user_id;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.accountType = accountType;
	}
	
	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int user_id) {
		this.cust_id = cust_id;
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

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + cust_id;
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
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (cust_id != other.cust_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [user_id=" + cust_id + ", accountNumber=" + accountNumber + ", balance=" + balance
				+ ", accountType=" + accountType + "]";
	}
	
	
}
