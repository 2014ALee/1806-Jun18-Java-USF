package com.revature;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.Driver;
import com.revature.models.Account;
import com.revature.models.User;

public class DriverTest {
	
	Driver driver = new Driver();
	
	@Test
	public void testBalance() {
		driver.setUser(new User(1, "cdefaria", "cdefaria@gmail.com", "password"));
		driver.setAccount(new Account(true, 1, 100));
		double bal = Driver.balance("0");
		assertEquals(bal, Driver.account.getBalance(), 0.0);
			
	}
	
	@Test
	public void testAccountsMenu() {
		driver.setUser(new User(1, "cdefaria", "cdefaria@gmail.com", "password"));
		driver.setAccount(new Account(true, 1, 100));
		int result = Driver.accountsMenu("0");
		assertEquals(result, 2);
	}
	
	@Test
	public void testLoginUsername() {
		assertEquals(Driver.login("cdefaria", "password"), new User(1, "cdefaria", "cdefaria@gmail.com", "password"));
	}
	
	@Test
	public void testLoginEmail() {
		assertEquals(Driver.login("cdefaria@gmail.com", "password"), new User(1, "cdefaria", "cdefaria@gmail.com", "password"));
	}
	
	@Test
	public void testLoginBad() {
		assertEquals(Driver.login("cdefaria", ""), null);
	}
}
