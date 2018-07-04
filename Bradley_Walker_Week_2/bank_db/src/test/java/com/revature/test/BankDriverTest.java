package com.revature.test;

import org.junit.BeforeClass;

import com.revature.dao.AccountDAOImpl;
import com.revature.dao.UserDAOImpl;
import com.revature.models.Account;
import com.revature.models.User;

public class BankDriverTest {

	private static Account account;
	private static User user;
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
		user = userDAO.addUser(u);
		
		Account a = new Account();
		a.setAccountName("testAccount");
		a.setBalance(1000);
		a.setFrozen(false);
		account = accountDAO.addAccount(user.getUserID(), a);
	}
	
	
}
