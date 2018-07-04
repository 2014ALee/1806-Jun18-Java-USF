package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Account;
import com.revature.models.User;

public interface AccountsDAO {

	public ArrayList<Account> getAllAccounts();
	// check if active user is accountHolder
	public ArrayList<User> getAllAccountUsers(User activeUser);
	
	public ArrayList<User> getAllAccountUsers(int accountId);
	
	public int getAccountHolderId(int accountId);
	
	public int getUserCheckingId(int userId);
	
	public int getUserSavingsId(int Id);

	public int getAccountCheckingId(int accountId);
	
	public int getAccountSavingsId(int accountId);
	
	public boolean createAccount(User accountHolder);
	
	public boolean authorizeUser(User accountHolder, int newUserId);
	
	public boolean deAuthorizeUser(User accountHolder, int oldUserId);
	
	public int getAccountIdByUser(User myUser);
}
