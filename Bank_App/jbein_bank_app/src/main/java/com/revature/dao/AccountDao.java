package com.revature.dao;

import com.revature.models.Account;

public interface AccountDao {
	
	public Account GetAccount(int user_id);
	public Account createAccount(Account account);
	public boolean Deposit(Account account, double depositAmount);
	public boolean Withdraw(Account account, double withdrawalAmount);
	

}
