package com.revature.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class HelpersTest {

	@Test
	public void testBalanceTooLow() {

		//test for negative withdrawal restriction by testing the balanceTooLow() function on all 3 bank account types for both legal and illegal withdrawals

		//set up a test user to pass to balanceTooLow() with a balance of $150 in all 3 accounts
		User u = new User();
		u.setCheckingBalance(150);
		u.setSavingsBalance(150);
		u.setJointBalance(150);
		u.setHasCheckingAccount(true);
		u.setHasSavingsAccount(true);
		u.setHasJointAccount(true);

		//set a value to pass to balanceTooLow() in order to represent a withdraw of $200 that would put the account into the negatives
		double amountTooMuch = 200;
		//set a string to pass to balanceTooLow() in order to choose which account to withdraw from
		String accountChosen;
		//set a target boolean for the balanceTooLow() method's return to match in order to test an illegal withdrawal
		boolean trueTarget = true;

		//test the balanceTooLow() results against the trueTarget for checking
		accountChosen = "Checking";
		assertEquals("balanceTooLow() did not return the correct boolean for the checking account", trueTarget, Helpers.balanceTooLow(accountChosen, amountTooMuch, u));

		//test the balanceTooLow() results against the trueTarget for savings
		accountChosen = "Savings";
		assertEquals("balanceTooLow() did not return the correct boolean for the savings account", trueTarget, Helpers.balanceTooLow(accountChosen, amountTooMuch, u));

		//test the balanceTooLow() results against the trueTarget for joint
		accountChosen = "Joint";
		assertEquals("balanceTooLow() did not return the correct boolean for the joint account", trueTarget, Helpers.balanceTooLow(accountChosen, amountTooMuch, u));

		//set a value to pass to balanceTooLow() in order to represent a withdraw of $90 that would NOT put the balance into the negatives
		double amountToWithdraw = 90;
		//set a target boolean for the balanceTooLow() method's return to match in order to test a legal withdrawal
		boolean falseTarget = false;

		//test the balanceTooLow() results against the falseTarget for checking
		accountChosen = "Checking";
		assertEquals("balanceTooLow() did not return the correct boolean for the checking account", falseTarget, Helpers.balanceTooLow(accountChosen, amountToWithdraw, u));

		//test the balanceTooLow() results against the falseTarget for savings
		accountChosen = "Savings";
		assertEquals("balanceTooLow() did not return the correct boolean for the savings account", falseTarget, Helpers.balanceTooLow(accountChosen, amountToWithdraw, u));

		//test the balanceTooLow() results against the falseTarget for joint
		accountChosen = "Joint";
		assertEquals("balanceTooLow() did not return the correct boolean for the joint account", falseTarget, Helpers.balanceTooLow(accountChosen, amountToWithdraw, u));

	}

	@Test
	public void testAccountExists() {

		//test whether or not each account exists for the user

		//set up a test user to pass to balanceTooLow() with all 3 accounts existing
		User u1 = new User();
		u1.setHasCheckingAccount(true);
		u1.setHasSavingsAccount(true);
		u1.setHasJointAccount(true);

		//set a string to pass to accountExists() in order to choose which account we want to know exists or not
		String accountChosen;
		//set a target boolean for the accountExists() method's return to match in order to test if the account exists
		boolean trueTarget = true;

		//test the accountExists() results against the trueTarget for checking
		accountChosen = "1";
		assertEquals("accountExists() did not return the correct boolean for the checking account", trueTarget, Helpers.accountExists(accountChosen, u1));

		//test the accountExists() results against the trueTarget for savings
		accountChosen = "2";
		assertEquals("accountExists() did not return the correct boolean for the savings account", trueTarget, Helpers.accountExists(accountChosen, u1));

		//test the accountExists() results against the trueTarget for joint
		accountChosen = "3";
		assertEquals("accountExists() did not return the correct boolean for the joint account", trueTarget, Helpers.accountExists(accountChosen, u1));

		//set up another test user to pass to balanceTooLow() with none of the accounts existing
		User u2 = new User();
		u2.setHasCheckingAccount(false);
		u2.setHasSavingsAccount(false);
		u2.setHasJointAccount(false);

		//set a target boolean for the accountExists() method's return to match in order to test if the account exists
		boolean falseTarget = false;

		//test the accountExists() results against the falseTarget for checking
		accountChosen = "1";
		assertEquals("accountExists() did not return the correct boolean for the checking account", falseTarget, Helpers.accountExists(accountChosen, u2));

		//test the accountExists() results against the falseTarget for savings
		accountChosen = "2";
		assertEquals("accountExists() did not return the correct boolean for the savings account", falseTarget, Helpers.accountExists(accountChosen, u2));

		//test the accountExists() results against the falseTarget for joint
		accountChosen = "3";
		assertEquals("accountExists() did not return the correct boolean for the joint account", falseTarget, Helpers.accountExists(accountChosen, u2));

	}
}
