package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Account;
import com.revature.models.User;

public interface UserDAO {
	
	public ArrayList<User> getAllUsers();
	public User getUserById(int ind);
	public User getUserByName(String name);
	
	public User addUser(User newUser);
	public boolean updateUser(User updatedUser);
	public boolean removeUserById(User userForRemoval);
	public boolean removeUserByName(String userName);
	
	
	public ArrayList<Account> getUserAccount(User selectedUser);


}