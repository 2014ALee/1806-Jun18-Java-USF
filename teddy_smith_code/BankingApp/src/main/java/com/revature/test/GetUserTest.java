package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.Dao.UserDAO;
import com.revature.model.User;

public class GetUserTest {

		@Test
		public void testGetUserSuccessful() {
			User tester = new User();
			User user1 = new User(0, "Theodore", "Smith", "", "", "" );
			User actualUser = new User(1, "Theodore", "Smith", "theodore,smith@gmail.com", "", "");
			assertEquals("Should run successfully because there IS a user in the database that matches", actualUser, ((UserDAO) tester).GetUser(user1));	
		}

	}