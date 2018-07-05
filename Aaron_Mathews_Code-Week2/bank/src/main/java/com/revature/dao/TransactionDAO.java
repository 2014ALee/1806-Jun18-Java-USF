package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Account;
import com.revature.models.Transaction;

public interface TransactionDAO {
	
	public Transaction createTransaction(Transaction trans);
	
	public ArrayList<Transaction> getAllTransaction(Account account);
}
