package com.revature.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.exceptions.NegativeAmountException;
import com.revature.models.BankAccount;

public class TestBankAccount {

	@Test
	public void test() {
		// Test when account is created.
		BankAccount bankAccount = new BankAccount(25, "Scar", "p4ssw0rd");
		assertEquals("Making sure the bankid works fine.",
				bankAccount.getId(), 25);
		assertEquals("Making sure the username works fine.",
				bankAccount.getUsername().equalsIgnoreCase("Scar"), true);
		assertEquals("Making sure the password works fine.",
				bankAccount.checkAuthentication("p4ssw0rd"), true);
		assertEquals("Returning false for incorrect credentials.",
				bankAccount.checkAuthentication("P4ssw0rd"), false);
		assertEquals("Making sure initial bank accounts are 0 balance",
				bankAccount.getPennies() == 0, true);
		System.out.println("Account created, password check works.");
		boolean withdrawSuccess = false;
		boolean negativeAmtException = false;
		try {
			withdrawSuccess = bankAccount.withdraw(0.01);
		} catch (NegativeAmountException e) {}
		assertEquals("Should fail to withdraw since account was empty",
				withdrawSuccess, false);
		assertEquals("Balance should remain the same since withdrawal "
				+ "was a failure.", bankAccount.getPennies() == 0, true);
		try {
			bankAccount.withdraw(-0.01);
		} catch (NegativeAmountException e) {
			negativeAmtException = true;
		}
		assertEquals("Should fail due to inability to withdraw."
				+ " a negative amount. ", negativeAmtException,
				true);
		negativeAmtException = false;
		try {
			bankAccount.deposit(-1.00);
		} catch (NegativeAmountException e) {
			negativeAmtException = true;
		}
		assertEquals("Shouldn\'t be able to deposit a negative amount either.",
				negativeAmtException, true);
		
		assertEquals("Balance should remain the same "
				+ "since withdrawal and deposits were "
				+ "failures.",
				bankAccount.getPennies() == 0, true);
		try {
			bankAccount.deposit(9999.95001);
		} catch (NegativeAmountException e) {}
		assertEquals("Balance should be updated after a successful deposit.",
				bankAccount.getPennies(), 999995);

		try {
			bankAccount.withdraw(49.949999);
		} catch (NegativeAmountException e) {}
		assertEquals("Balance should be updated after a successful withdrawal.",
				bankAccount.getPennies(),  995000);
		System.out.println("Balance changing works as should.");
		try {
			bankAccount.withdraw(49.949999);
		} catch (NegativeAmountException e) {}
		assertEquals("Balance should be printed in a nice manner.",
				bankAccount.getBalance().equals("9900.05"),  true);
	}

}
