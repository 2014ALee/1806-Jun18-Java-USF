package com.revature.model;

import java.io.Serializable;

public class Customers implements Serializable {
	
	private String userName;
	private String password;
	private int checkingAcct; //not implemented
	private int savingsAcct; // not implemented
	private int balance;
	
	public Customers() {}

	public Customers(String username, String password) {
		super();
		this.userName = username;
		this.password = password;
	}
	public Customers(String userName, String password, int checkingAcct, int savingsAcct) {
		super();
		this.userName = userName;
		this.password = password;
		this.checkingAcct = checkingAcct;
		this.savingsAcct = savingsAcct;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCheckingAcct() {
		return checkingAcct;
	}

	public void setCheckingAcct(int checkingAcct) {
		this.checkingAcct = checkingAcct;
	}

	public int getSavingsAcct() {
		return savingsAcct;
	}

	public void setSavingsAcct(int savingsAcct) {
		this.savingsAcct = savingsAcct;
	}
	
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int account) {
		balance = account;
	}
	
	public void subtract(int sub) {
		balance -= sub;
	}
	
	public void add(int sub) {
		balance += sub;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + checkingAcct;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + savingsAcct;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		Customers other = (Customers) obj;
		if (checkingAcct != other.checkingAcct)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (savingsAcct != other.savingsAcct)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customers [userName=" + userName + ", password=" + password + ", checkingAcct=" + checkingAcct
				+ ", savingsAcct=" + savingsAcct + "]";
	}
		
}
