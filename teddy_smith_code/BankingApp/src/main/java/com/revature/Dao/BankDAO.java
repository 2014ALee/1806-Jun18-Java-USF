package com.revature.Dao;

import java.util.ArrayList;

import com.revature.model.Account;
import com.revature.model.User;

public interface BankDAO {

	public Account GetCredential(int user_id);
	
	public double getCredbalance(Account acct);
	public ArrayList<Account> GetFunds(User a);
	public Account createCredential(User a, String username);
	
	public boolean Deposit(Account credential, double depositAmount);
	
	public boolean Withdraw(Account credential, double withdrawAmount);

	
}
