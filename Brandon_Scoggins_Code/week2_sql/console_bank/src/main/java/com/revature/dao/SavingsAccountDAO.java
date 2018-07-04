package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.SavingsAccount;
import com.revature.models.User;

public interface SavingsAccountDAO {

	public double getSavingsBalanceByUser(User currentUser);
	
	public double getSavingsBalanceByAccountId(int accountId);
	
	public boolean depositSavings(User currentUser, int targetAccountId, double amount);
	
	public boolean withdrawSavings(User currentUser, int targetAccountId, double amount);
	
	public boolean createSavings(User currentUser);
	
	public boolean pairSavingsToAccount(User currentUser);
	
	public boolean deleteSavings(User currentUser);
	
	public ArrayList<SavingsAccount> getAllSavingsAccounts();	
}
