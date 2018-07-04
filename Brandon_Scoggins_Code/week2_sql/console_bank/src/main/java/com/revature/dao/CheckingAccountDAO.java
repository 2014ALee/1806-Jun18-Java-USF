package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.CheckingAccount;
import com.revature.models.User;

public interface CheckingAccountDAO {

	public double getCheckingBalanceByUser(User currentUser);
	
	public double getCheckingBalanceByAccountId(int accountId);
	
	public boolean depositChecking(User currentUser, int targetAccountId, double amount);
	
	public boolean withdrawChecking(User currentUser, int targetAccountId, double amount);
	
	public boolean createChecking(User currentUser);
	
	public boolean pairCheckingToAccount(User currentUser);
	
	public boolean deleteChecking(User currentUser);
	
	public ArrayList<CheckingAccount> getAllCheckingAccounts();	
}
