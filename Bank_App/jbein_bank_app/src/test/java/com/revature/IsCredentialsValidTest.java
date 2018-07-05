package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.models.User;

public class IsCredentialsValidTest {

	@Test
	public void testCredentialsValidTrue() {
		String username = "jbein";
		String pw = "123";
		assertEquals("Should return true because these are valid credentials.",
				true, BankAppDriver.credentialsValid(username, pw));;

	}
	
	@Test
	public void testCredentialsValidFalse() {
		String username = "jbeineke";
		String pw = "123";
		assertEquals("Should return false because these are invalid credentials.", 
				false, BankAppDriver.credentialsValid(username, pw));

	}

}
