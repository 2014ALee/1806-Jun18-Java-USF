package com.revature.models.interfaces;

public interface BankAccountInterface {

	public boolean deposit(double amount);
	public boolean withdraw(double amount);
	
	public double getBalance();
	public String getUserName();
	public String getPassword();
	
	public void setBalance(double balance); 
	public void setUserName(String userName);
	public void setPassword(String password);
	
	public String toString();
	public boolean equals(Object obj);
}
