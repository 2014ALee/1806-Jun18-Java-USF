package com.revature;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.junit.Ignore;
import org.junit.Test;

import com.revature.Driver;
import com.revature.models.Account;
import com.revature.models.User;

public class DriverTest {
	
	Driver driver = new Driver();
	
	@Test
	public void testBalance() {
		String testText = "0\n";
		driver.setUser(new User(1, "cdefaria", "cdefaria@gmail.com", "password"));
		driver.setAccount(new Account(true, 1, 100));
		InputStream old = System.in;
		try {
			InputStream testInput = new ByteArrayInputStream( testText.getBytes("UTF-8") );
			System.setIn( testInput );
			double bal = driver.balance();
			assertEquals(bal, driver.account.getBalance(), 0.0);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			System.setIn( old );
		}
	}
}
