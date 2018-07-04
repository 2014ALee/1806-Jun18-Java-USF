package bank.run.dao;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

import bank.run.util.Account;
import bank.run.util.User;

public class AccountDAOImplTest {
	static AccountDAOImpl accImpl = new AccountDAOImpl();
	static Account acc = new Account();
	static User user = new User();
	static UserDAOImpl userImpl = new UserDAOImpl();
	
	@Test
	public void testGetAccountByUserId() {
		acc.setUserID(41);
		//admin ID = 61
		assertTrue("this one failed" + accImpl.getAccountByUserId(acc.getUserID()).getAccountID(), (accImpl.getAccountByUserId(acc.getUserID())).getAccountID() == 61);
	}
	
	@Test
	public void testUpdateAccount() {
		acc.setAccountID(61);
		acc.setUserID(41);
		acc.setChecking(10);
		acc.setSavings(10);
		AccountDAOImpl accImpl = new AccountDAOImpl();
		accImpl.updateAccount(acc);
		acc.setChecking(0);
		acc.setSavings(0);
		assertTrue("this one failed 2",accImpl.updateAccount(acc));
	}
	
	@Test
	public void testInsertAccount() {
		user.setUserID(1);
		user.setUsername("test");
		user.setLastName("Case");
		user.setEmail("test.case@email.com");
		UserDAOImpl userImpl = new UserDAOImpl();
		userImpl.insertUser(user);
		user = userImpl.getUserByUsername("test");
		acc.setAccountID(1);
		acc.setUserID(user.getUserID());
		acc.setChecking(10);
		acc.setSavings(10);
		accImpl.insertAccount(acc);
		Account temp = accImpl.getAccountByUserId(acc.getUserID());
		acc.setAccountID(temp.getAccountID());
		assertTrue("this is failed 3", temp.equals(acc));
	}
	
	@Test
	public void testDeleteAccount() {
		user = userImpl.getUserByUsername("test");
		acc = accImpl.getAccountByUserId(user.getUserID());
		assertTrue("account deleted", accImpl.deleteAccount(acc));
		userImpl.deleteUser(user);
	}
	
}
