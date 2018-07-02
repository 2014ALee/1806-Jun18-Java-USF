package com.revature.models;

import java.io.Serializable;

// Bank User POJO (Plain Old Java Object)
public class BankUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String passWord;
	private String balance;
	
	public BankUser() {
		this.userName = null;
		this.passWord = null;
		this.balance = null;
	}
	
	public BankUser(String userName, String passWord, String balance) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.balance = balance;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassWord() {
		return passWord;
	}
	
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public String getBalance() {
		return balance;
	}
	
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
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
		BankUser other = (BankUser) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (passWord == null) {
			if (other.passWord != null)
				return false;
		} else if (!passWord.equals(other.passWord))
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
		return "BankUser [userName=" + userName + ", passWord=" + passWord + ", balance=" + balance + "]";
	}
}
