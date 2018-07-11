package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Account;

public interface AccountDAO {

	public ArrayList<Account> getAllAccounts();
	public Account getAccountById(int ind);
	public Account getAccountByName(String name);
	
	public Account addAccount(Account newAccount);
	public boolean updateAccount(Account updatedAccount);
	public boolean removeAccountById(Account accountForRemoval);
	public boolean removeAccountByName(String accountName);
	
}
