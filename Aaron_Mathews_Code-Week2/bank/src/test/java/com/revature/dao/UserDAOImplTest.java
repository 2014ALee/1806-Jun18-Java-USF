package com.revature.dao;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.revature.models.User;

class UserDAOImplTest {
	
	User user1 = new User(1, "jj", "jason", "james", "jjames@gmail.com", "password");
	User user2 = new User(555, "test", "jason", "james", "jjames@gmail.com", "password");
	UserDAOImpl userDAO = new UserDAOImpl();
	
	@Ignore
	void testCreateUser1() {
		User test = userDAO.createUser(user1);
		
		assertFalse(user1.equals(test));
	}
	
	@Ignore
	void testGetUserByUsername() {
		User test = userDAO.getUserByUsername("jj");
		
		assertTrue(test.equals(user1));
	}
	
	@Ignore
	void testGetUserById() {
		User test = userDAO.getUserById(user1);
		
		assertTrue(test.equals(user1));
	}

}
