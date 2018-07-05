package com.revature.util;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.TreeMap;

import org.junit.jupiter.api.Test;

import com.revature.models.BankAccount;
import com.revature.models.DatabaseBackUp;
import com.revature.models.User;

class DatabaseBackUpTest {

	DatabaseBackUp testDatabase = new DatabaseBackUp();	

	User testUser = new User("first", "last", "username", "password");	

	BankAccount userAccount = testUser.getBankAccount();

	TreeMap<String, User> userBank;

	@Test
	void testGetAllUsers() {
		userBank = testDatabase.getUsers();

		assertEquals("We try to get user bobross, and they don't exist", null, userBank.get("bobross"));
	}

	@Test
	void registerAccountTest() {
		assertEquals("Account registered succesfully", true, testDatabase.registerAccount(testUser, userAccount));
	}

	@Test
	void setBalanceTo1000() {
		assertEquals("Set balance successfully", true, testDatabase.setBalance(1000, testUser, userAccount));
	}

}
