package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Account;
import com.revature.models.User;

public interface UserDAO {
	
	public ArrayList<User> getAllUsers();
	public User getUserById(int ind);
	public User getUserByName(String name);
	
	public User addUser(User newArtist);
	public boolean updateUser(User updatedArtist);
	public boolean removeUserById(User artistForRemoval);
	public boolean removeUserByName(String artistName);
	
	
	public ArrayList<Account> getUserAccount(User selectedUser);


}