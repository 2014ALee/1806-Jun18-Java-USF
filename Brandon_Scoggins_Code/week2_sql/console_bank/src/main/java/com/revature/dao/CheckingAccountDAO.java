package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.CheckingAccount;
import com.revature.models.User;

public interface CheckingAccountDAO {

	public double getCheckingBalance(User currentUser);
	
	public boolean depositChecking(User currentUser, double amount);
	
	public boolean withdrawChecking(User currentUser, double amount);
	
	public boolean createChecking(User currentUser);
	
	public boolean pairCheckingToAccount(User currentUser);
	
	public boolean deleteChecking(User currentUser);
	
	public ArrayList<CheckingAccount> getAllCheckingAccounts();	
}
