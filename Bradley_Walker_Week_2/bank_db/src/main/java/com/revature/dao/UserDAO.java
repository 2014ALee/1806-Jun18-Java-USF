package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Account;
import com.revature.models.Loan;
import com.revature.models.Transaction;
import com.revature.models.Transfer;
import com.revature.models.User;

public interface UserDAO {
	// Create
	public User addUser(User user);
	
	// Read
	public ArrayList<User> getAllUsers();
	public ArrayList<User> getAllUsersExcept(int id);
	public User getUserByID(int id);
	public User getUserByUsername(String username);
	public ArrayList<Account> getUserAccounts(User user);
	
	// Update
	public boolean updateUser(User user);
}
