package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.SavingsAccount;
import com.revature.models.User;

public interface SavingsAccountDAO {
	
	public double getSavingsBalance(User currentUser);
	
	public void depositSavings(User currentUser, double amount);
	
	public void withdrawSavings(User currentUser, double amount);
	
	public void createSavings(User currentUser);
	
	public void deleteSavings(User currentUser);
	
	public ArrayList<SavingsAccount> getAllSavingsAccounts();
}
