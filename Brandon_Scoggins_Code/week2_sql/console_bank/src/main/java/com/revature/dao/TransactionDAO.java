package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Transaction;
import com.revature.models.User;

public interface TransactionDAO {

	public ArrayList<Transaction> getUserTransactions(User currentUser); 		// may allow to see transactions of joint users specifically

	public ArrayList<Transaction> getAccountTransactions(User currentUser);		// can only see account wide history if you are the account holder

	public void transferFunds(User currentUser, int targetAccount, double amount); // ask if target is checking or savings (1 or 2 option on menu)

	public ArrayList<Transaction> getAllTransactions();
}

/*
 * Maybe allow for date or amount range of transaction look up
 */
