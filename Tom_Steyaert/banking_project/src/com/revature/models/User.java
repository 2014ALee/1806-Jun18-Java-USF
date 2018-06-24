package com.revature.models;

import java.io.Serializable;

public class User implements Comparable, Serializable{

	private static final long serialVersionUID = 1L;
	
	private int balance = 0;
	private String userName;
	private String password;

	//we will initially take in 0 as the balance
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public void deposit(int amount) {
		balance += amount;
	}
	
	public boolean withdraw(int amount) {

		if(amount > balance) {
			return false;
		} else {

			balance -= amount;
			return true;
		}
	}

	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
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



	@Override
	public String toString() {
		return "User [balance=" + balance + ", userName=" + userName + ", password=" + password + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + balance;
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
		User other = (User) obj;
		if (balance != other.balance)
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
	public int compareTo(Object o) {
		return 0;
	}
}
