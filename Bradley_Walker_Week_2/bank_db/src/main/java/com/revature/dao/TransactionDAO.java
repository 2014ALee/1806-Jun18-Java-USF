package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Transaction;

public interface TransactionDAO {
	
	// Create
	public boolean addTransaction(Transaction transaction);
	
	// Read
	public ArrayList<Transaction> getTransactionsForUser(int id);
	public ArrayList<Transaction> getTransactionsForAccount(int id);

}
