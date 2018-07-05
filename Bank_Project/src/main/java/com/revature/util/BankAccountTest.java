package com.revature.util;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.models.BankAccount;

class BankAccountTest {

	BankAccount test = new BankAccount("AndrewLi", "Password");
	
	@Test
	void isUSDFormat() {
		assertEquals("5.23423 is not USD format, so false", false, test.isUSDFormat(5.23423));
	}
	
	@Test
	void depositNegative100Test() {
		assertEquals("-100 is not the correct format for deposit, so false", false, test.deposit(-100));
	}	

	@Test
	void withdraw50Test() {
		test.setBalance(1000);
		assertEquals("50 is the correct format for deposit, so true", true, test.withdraw(50));
	}	

	
}
