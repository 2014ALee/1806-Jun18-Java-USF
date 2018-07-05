package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Account;
import com.revature.models.User;

public interface AccountDAO {
	
	public Account createAccount(Account account, User user);
	
	public Account getAccountById(int accountid);

	public boolean deposit(int accountid, double value);
	
	public boolean withdraw(int accountid, double value);
	
	public boolean checkUsername(String username);
	
	public boolean checkEmail(String email);
	
	public Account getAccountByUser(User user);
	
	public ArrayList<Account> getAllAccounts();

}
