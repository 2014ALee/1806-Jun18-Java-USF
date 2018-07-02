package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Account;
import com.revature.models.User;

public interface AccountDAO {
	
	public ArrayList<Account> getAllUserAccounts(int userId);
	public Account getAccount(int userId, boolean type);
	
	public boolean updateAccountBalance(Account a);
	
	public Account createAccount(Account account, User user);

}
