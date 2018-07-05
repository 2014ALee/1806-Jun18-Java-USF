package com.revature.dao;

import com.revature.models.BankAccount;

public interface BankUserDAO {

	public abstract BankAccount getBankUserByUsername(String username);
	public abstract boolean addBankUser(String username, String password);
	public abstract boolean updateBankUserBalance(BankAccount updatedBankUser);
	
}
