package com.revature.test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.BankDriver;
import com.revature.dao.AccountDAOImpl;
import com.revature.dao.UserDAOImpl;
import com.revature.models.Account;
import com.revature.models.User;

public class BankDriverTest {

	private static Account account;
	private static Account account2;
	private static User user1;
	private static UserDAOImpl userDAO = new UserDAOImpl();
	private static AccountDAOImpl accountDAO = new AccountDAOImpl();

	@BeforeClass
	public static void createData() {
		User u = new User();
		u.setUsername("test");
		u.setPwHash("1234");
		u.setPwSalt("1234");
		u.setEmail("test@revature.com");
		u.setPhone("(123) 456-7890");
		u.setFrozen(false);
		user1 = userDAO.addUser(u);
		
		Account a = new Account();
		a.setAccountName("testAccount");
		a.setBalance(1000);
		a.setFrozen(false);
		account = accountDAO.addAccount(user1.getUserID(), a);
		
		a = new Account();
		a.setAccountName("other test Account");
		a.setBalance(500);
		a.setFrozen(false);
		account2 = accountDAO.addAccount(user1.getUserID(), a);
	}
	
	@Test
	public void testFreeze() {
		assertEquals(true, BankDriver.doFreeze(user1, true));
		assertEquals(true, BankDriver.doFreeze(user1, false));
	}
	
	@Test
	public void testCreateAccount() {
		assertEquals(false, BankDriver.doCreateAccount(user1.getUserID(), account));
	}
	
	@Test
	public void testTransfer() {
		assertEquals(true, BankDriver.doTransfer(account, account2, 100));
	}
	
	@Test
	public void testDeposit() {
		assertEquals(true, BankDriver.doDeposit(account, 100));
	}
	
	@Test
	public void testWithdraw() {
		assertEquals(true, BankDriver.doWithdraw(account, 100));
	}
	
	@Test
	public void testHash() {
		// Even if 2 passwords are the exact same, if the salts are different, the hashes will be different.
		String pw = "This is my secret password";
		String salt1 = "gso0274ndotrtts5";
		String salt2 = "loppgdtt63890ist";
		
		assertEquals(false, BankDriver.hashPassword(pw, salt1) == BankDriver.hashPassword(pw, salt2));
	}
	
	@AfterClass
	public static void deleteData() {
		userDAO.deleteUser(user1);
		accountDAO.deleteAccount(account);
		accountDAO.deleteAccount(account2);
	}
}
