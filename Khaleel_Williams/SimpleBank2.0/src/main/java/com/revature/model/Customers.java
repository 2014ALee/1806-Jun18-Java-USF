package com.revature.model;

import java.io.Serializable;

public class Customers implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private float balance;
	
	
	public Customers() {}

	public Customers(String username, String password) {
		super();
		this.userName = username;
		this.password = password;
		this.balance = 0;
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
	
	public float getBalance() {
		return balance;
	}

	public void setBalance(float f) {
		balance = f;
	}
	
	public void subtract(float sub) {
		balance -= sub;
	}
	
	public void add(float sub) {
		balance += sub;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(balance);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		if (Float.floatToIntBits(balance) != Float.floatToIntBits(other.balance))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
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
		return "Customers [userName=" + userName + ", password=" + password + ", balance=" + balance + "]";
	}

}
