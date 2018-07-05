package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.dao.AccountDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.models.User;

public class GetUserTest {

	@Test
	public void testGetUserSuccessful() {
		UserDaoImpl tester = new UserDaoImpl();
		User user1 = new User(0, "John", "Beineke", "" );
		User actualUser = new User(1, "John", "Beineke", "john.beineke@gmail.com");
		assertEquals("Should run successfully because there IS a user in the database that matches", actualUser, tester.GetUser(user1));	
	}

}
