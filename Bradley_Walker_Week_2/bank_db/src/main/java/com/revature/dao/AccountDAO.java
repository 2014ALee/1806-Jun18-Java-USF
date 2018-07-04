package com.revature.dao;

import com.revature.models.Account;

public interface AccountDAO {
	
	// Create
	public Account addAccount(int userID, Account account);
	public Account addJointAccount(int userID1, int userID2, Account account);
	
	// Read
	public Account getAccountByID(int id);
	
	// Update
	public boolean updateAccount(Account account);
	
}
