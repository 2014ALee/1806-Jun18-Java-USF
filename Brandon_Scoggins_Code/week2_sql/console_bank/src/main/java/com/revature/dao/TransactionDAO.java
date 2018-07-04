package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Transaction;
import com.revature.models.User;

public interface TransactionDAO {

	public ArrayList<Transaction> getTransactionsByUserId(User currentUser, int userId); 		// may allow to see transactions of joint users specifically

	public ArrayList<Transaction> getAccountTransactions(User currentUser);		// can only see account wide history if you are the account holder

	public boolean recordTransaction(User currentUser, int originAccount, String originType, int targetAccount, String targetType, double amount); // ask if target is checking or savings (1 or 2 option on menu)

	public ArrayList<Transaction> getAllTransactions();
}

/*
 * Maybe allow for date or amount range of transaction look up
 */
