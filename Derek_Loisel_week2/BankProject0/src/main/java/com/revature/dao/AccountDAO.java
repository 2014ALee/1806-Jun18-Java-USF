package com.revature.dao;

import com.revature.models.Account;

public interface AccountDAO {

	public Account getAccountByUserID (Account account);
	
	public Account addAccount(Account newAccount);
	
	public boolean updateAccount(Account updatedAccount);
}
