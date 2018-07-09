package com.revature.dao;

import com.revature.models.User;

public interface usersDao {
	User newUser(User u);
	void removeUser(User u);
}
