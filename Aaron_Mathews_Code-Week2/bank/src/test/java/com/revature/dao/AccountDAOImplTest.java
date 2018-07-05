package com.revature.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.revature.models.Account;
import com.revature.models.User;

class AccountDAOImplTest {
	AccountDAOImpl accDAO = new AccountDAOImpl();
	
	User user1 = new User(1, "jj", "jason", "james", "jjames@gmail.com", "password");
	Account acc1 = new Account(1, 0.00, user1.getUserId());
	Account account = accDAO.createAccount(acc1, user1);
 
	@Test
	void testAccountCreation1() {
		assertTrue(account != null);
	}
	
	@Test
	void testAccountCreation2() {
		assertTrue(account.getOwnerId() == (user1.getUserId()));
	}

	@Ignore
	void testGetAccountByUser() {
		Account test = accDAO.getAccountByUser(user1);
		
		assertTrue(account.equals(test));
	}
	
	@Test
	void testDeposit() {
		boolean deposit = accDAO.deposit(account.getAccountId(), 50);
		
		assertTrue(deposit);
	}
	
	@Test
	void testWithdraw() {
		boolean withdraw = accDAO.withdraw(account.getAccountId(), 50);
		
		assertTrue(withdraw);
	}
	
	@Test
	void testWithdraw2() {
		boolean withdraw = accDAO.withdraw(0, 500000);
		
		assertFalse(withdraw);
	}
	
	@Test
	void testCheckUsername1() {
		boolean username = accDAO.checkUsername("thththt");
		
		assertTrue(username);
	}
	
	@Test
	void testCheckUsername2() {
		boolean username = accDAO.checkUsername("amath");
		
		assertFalse(username);
	}
	
	@Test
	void testCheckEmail1() {
		boolean email = accDAO.checkEmail("you@gmail.com");
		
		assertTrue(email);
	}
	
	@Test
	void testCheckEmail2() {
		boolean email = accDAO.checkEmail("amath@gmail.com");
		
		assertFalse(email);
	}
}
