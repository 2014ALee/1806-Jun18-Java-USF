package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.dao.UserDaoImpl;
import com.revature.models.User;

public class UsernameAvailableTest {

	@Test
	public void testUsernameAvailableFalse() {
		User user1 = new User(0, "John", "Beineke", "" );
		assertEquals("Should return false because the username 'John' is already "
				+ "in the database.", false, BankAppDriver.usernameAvailable(user1));
	    }
	
	@Test
	public void testUsernameAvailableTrue() {
		User user1 = new User(0, "Bill", "Password", "" );
		assertEquals("Should return true because the username 'Bill' is not in the database. "
				+ "in the database.", true, BankAppDriver.usernameAvailable(user1));
		
	    }
		
		
	
	}


