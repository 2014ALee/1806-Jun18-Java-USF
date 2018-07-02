package com.revature.dao;
import java.util.ArrayList;

import com.revature.models.User;

public interface UserDAO {
	
	public User getUserById(int id);
	
	public ArrayList<User> getUserByName(String name);
	
	public User createUser(User user);
	
	public boolean removeUserById(int id);
	
	public boolean updateUser(User user);
	
	public double getBalance(User user);
	
	public boolean addJoint(User user);

}

