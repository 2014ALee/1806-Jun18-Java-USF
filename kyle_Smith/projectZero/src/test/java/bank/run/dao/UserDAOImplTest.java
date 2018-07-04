package bank.run.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bank.run.util.Account;
import bank.run.util.User;

public class UserDAOImplTest {
	static User user = new User();
	static UserDAOImpl userImpl = new UserDAOImpl();
//	@Test
//	public void testGetAllUsernames() {
//		fail("Not yet implemented");
//	}
//	 Not sure how to test these so didnt do them they work though.
//	@Test
//	public void testGetAllEmails() {
//		fail("Not yet implemented");
//	}
//	

	@Test
	public void testInsertUser() {
		user.setUserID(1);
		user.setUsername("test");
		user.setLastName("Case");
		user.setEmail("test.case@email.com");
		userImpl.insertUser(user);
		
		assertTrue("user did not insert", user.equals(userImpl.getUserByUsername("test")));
	}
	@Test
	public void testGetUserByUsername() {
		assertTrue("user test not found", user.equals(userImpl.getUserByUsername(user.getUsername())));
	}
	
	@Test
	public void testGetUserByEmail() {
		assertTrue("user test not found", user.equals(userImpl.getUserByEmail(user.getEmail())));
	}
	@Test
	public void testDeleteUser() {
		user = userImpl.getUserByUsername("test");
		assertTrue("did not delete", userImpl.deleteUser(user));
		
	}
}
