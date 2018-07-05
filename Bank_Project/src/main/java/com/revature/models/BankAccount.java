package com.revature.models;

import java.text.DecimalFormat;

import com.revature.models.interfaces.BankAccountInterface;

public class BankAccount implements BankAccountInterface{

	private double balance = 0;
	private String userName;
	private String password;

	//we will initially take in 0 as the balance
	public BankAccount(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public static boolean isUSDFormat(double amount) {
		if(amount < 0) {
			return false;
		}

		DecimalFormat df = new DecimalFormat("0.00");
		double amountInUSD = Double.parseDouble(df.format(amount));

		if(amount!=amountInUSD) {
			return false;
		} else {
			return true;	
		}	
	}

	public boolean deposit(double amount) {
		boolean correctFormat = isUSDFormat(amount);

		if(!correctFormat) {
			return false;
		} else {

			balance += amount;
			return true;
		}
	}

	public boolean withdraw(double amount) {
		boolean correctFormat = isUSDFormat(amount);

		if(!correctFormat) {
			return false;
		}

		if(amount > balance) {
			return false;
		} else {
			balance -= amount;
			return true;
		}
	}

	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
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
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		BankAccount other = (BankAccount) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
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
}


