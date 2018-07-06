package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Account;
import com.revature.models.User;

public interface AccountDAO {
	public Account createAccount(Account a, User u) ;
	
	public ArrayList<Account> getAccounts(User u);
	
	// Could be an int, decide
	public boolean updateBalance(Account a);
}