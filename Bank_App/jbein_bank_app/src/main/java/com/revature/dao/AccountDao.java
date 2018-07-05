package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Account;
import com.revature.models.User;

public interface AccountDao {
	
	public Account GetAccount(int account_num);
	public double GetBalance(Account acct);
	public ArrayList<Account> GetAccounts(User u);
	public Account createAccount(User u, String accountType);
	public boolean Deposit(Account account, double depositAmount);
	public boolean Withdraw(Account account, double withdrawalAmount);	

}
