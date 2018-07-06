package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.BankAccount;
import com.revature.model.User;

import static org.junit.Assert.*;

//import org.junit.Test;

class Tester {

			@Test
			public void testUsernameAvailableFalse() {
				User user1 = new User(0, "Teddy", "Smith", "", "", "" );
				assertEquals("Should return false because the username 'Teddy' is already "
						+ "in the database.", true, BankAccount.usernameAvaliable(user1));
			    }
			
			@Test
			public void testUsernameAvailableTrue() {
				User user1 = new User(0, "Rob", "Gray", "", "", "" );
				assertEquals("Should return true because the username 'Rob' is not in the database. "
						+ "in the database.", false, BankAccount.usernameAvaliable(user1));
				
			    }
				
				
			
			}
		


