package com.revature.models;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.Test;
import com.revature.dao.UsersDAO;
import com.revature.dao.UsersDAOImpl;

public class ValidationTest {

	@Test
	public void testUsernameAndEmailAvailable() {

		//create a test user object
		User testUser = new User();
		testUser.setUsername("testUser");
		testUser.setPassword("pass");
		testUser.setFirstName("Test");
		testUser.setLastName("User");
		testUser.setEmail("testemail@gmail.com");

		//create a boolean to compare to the result of usernameAndEmailAvailable()
		boolean trueTest = true;

		//call usernameAndEmailAvailable() to check if the test user's data is in the database. 
		//The test user shouldn't be in the database yet so the return should be true because the username and email are available.
		assertEquals("usernameAndEmailAvailable() didn't return the correct boolean", trueTest, Validation.usernameAndEmailAvailable(testUser));

		//add the test user to the database 
		UsersDAO usersDAO = new UsersDAOImpl();
		User u1 = usersDAO.addUser(testUser);

		//create a boolean to compare to the result of usernameAndEmailAvailable()
		boolean falseTest = false;

		//Set username to an available username but email to an unavailable email
		u1.setEmail("newtestemail@gmail.com");

		//call usernameAndEmailAvailable() to check if the test user's data is in the database. 
		//The test user should be in the database so the return should be false because the username is not available
		assertEquals("usernameAndEmailAvailable() didn't return the correct boolean", falseTest, Validation.usernameAndEmailAvailable(testUser));

		//Set username to an unavailable username but email to an available email
		u1.setEmail("testemail@gmail.com");
		u1.setUsername("newtestuser");

		//call usernameAndEmailAvailable() to check if the test user's data is in the database. 
		//The test user should be in the database so the return should be false because the username is not available
		assertEquals("usernameAndEmailAvailable() didn't return the correct boolean", falseTest, Validation.usernameAndEmailAvailable(testUser));

	}

	@Test
	public void testCredentialsValid() {

		//create a test user object
		User testUser = new User();
		testUser.setUsername("testUser");
		testUser.setPassword("pass");

		//create a booleans to compare to the result of testCredentialsValid()
		boolean trueTest = true;
		boolean falseTest = false;
		
		//the credentials should be valid because the test user credentials are in the database
		assertEquals("credentialsValid() didn't return the correct boolean", trueTest, Validation.credentialsValid(testUser.getUsername(), testUser.getPassword()));

		//set the username to an incorrect username to test with a correct password
		testUser.setUsername("newUsername");
		assertEquals("credentialsValid() didn't return the correct boolean", falseTest, Validation.credentialsValid(testUser.getUsername(), testUser.getPassword()));
		
		//set the password to an incorrect password to test with a correct username
		testUser.setUsername("testUser");
		testUser.setPassword("newpass");
		assertEquals("credentialsValid() didn't return the correct boolean", falseTest, Validation.credentialsValid(testUser.getUsername(), testUser.getPassword()));
	}

	@AfterClass
	public static void removeTestUser() {
		//delete the test user from the database
		String deletedUsername = "testUser";
		UsersDAO usersDAO = new UsersDAOImpl();
		usersDAO.deleteUserByUsername(deletedUsername);
	}

}
