package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Transaction;
import com.revature.models.User;

public interface TransactionDAO {

	public ArrayList<Transaction> getTransactionsByUserId(User currentUser, int userId); 		

	public ArrayList<Transaction> getAccountTransactions(User currentUser);		

	public boolean recordTransaction(User currentUser, int originAccount, String originType, int targetAccount, String targetType, double amount);
}

/*
 * Maybe allow for date or amount range of transaction look up
 */
