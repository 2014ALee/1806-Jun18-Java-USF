package com.revature.dao;

import com.revature.models.Account;

public interface AccountDAO {
	
	Account addAccount(Account acct);
	Account getAccountById(int acctId);
	Account updateBalance(int acctId, double newBalance);

}
