package com.revature.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserActionsTest {

	@Test
	public void testDeposit() {

		//test the deposit() function on all 3 bank account types

		//set up a test user to pass to deposit() with a balance of $75 in all 3 accounts
		User u = new User();
		u.setCheckingBalance(75);
		u.setSavingsBalance(75);
		u.setJointBalance(75);
		u.setHasCheckingAccount(true);
		u.setHasSavingsAccount(true);
		u.setHasJointAccount(true);

		//set a value to pass to deposit() in order to represent a deposit of $50
		double amountToDeposit = 50;
		//set a string to pass to deposit() in order to choose which account to deposit to
		String accountChosen;
		//set a target value for the users new balance to be at after a deposit of $50
		double targetBalance = 125;

		//call the deposit() function for the checking account
		accountChosen = "Checking";
		u = UserActions.deposit(accountChosen, amountToDeposit, u);
		//test the deposit() results against the targetBalance
		assertEquals("The users checking balance was not correct after the deposit", Double.toString(targetBalance), Double.toString(u.getCheckingBalance()));

		//call the deposit() function for the savings account
		accountChosen = "Savings";
		u = UserActions.deposit(accountChosen, amountToDeposit, u);
		assertEquals("The users savings balance was not correct after the deposit", Double.toString(targetBalance), Double.toString(u.getSavingsBalance()));

		//call the deposit() function for the joint account
		accountChosen = "Joint";
		u = UserActions.deposit(accountChosen, amountToDeposit, u);
		assertEquals("The users joint balance was not correct after the deposit", Double.toString(targetBalance), Double.toString(u.getJointBalance()));

	}

	@Test
	public void testWithdraw() {

		//test the withdraw() function on all 3 bank account types (negative withdrawal restrictions are tested in the HelpersTest class)

		//set up a test user to pass to withdraw() with a balance of $150 in all 3 accounts
		User u = new User();
		u.setCheckingBalance(150);
		u.setSavingsBalance(150);
		u.setJointBalance(150);
		u.setHasCheckingAccount(true);
		u.setHasSavingsAccount(true);
		u.setHasJointAccount(true);

		//set a value to pass to withdraw() in order to represent a withdraw of $125
		double amountToWithdraw = 125;
		//set a string to pass to withdraw() in order to choose which account to withdraw from
		String accountChosen;
		//set a target value for the users new balance to be at after a withdraw of $125
		double targetBalance = 25;

		//call the withdraw() function for the checking account
		accountChosen = "Checking";
		u = UserActions.withdraw(accountChosen, amountToWithdraw, u);
		//test the withdraw() results against the targetBalance for checking
		assertEquals("The users checking balance was not correct after the withdraw", Double.toString(targetBalance), Double.toString(u.getCheckingBalance()));

		//call the withdraw() function for the savings account
		accountChosen = "Savings";
		u = UserActions.withdraw(accountChosen, amountToWithdraw, u);
		//test the withdraw() results against the targetBalance for savings
		assertEquals("The users savings balance was not correct after the withdraw", Double.toString(targetBalance), Double.toString(u.getSavingsBalance()));

		//call the withdraw() function for the joint account
		accountChosen = "Joint";
		u = UserActions.withdraw(accountChosen, amountToWithdraw, u);
		//test the withdraw() results against the targetBalance for joint
		assertEquals("The users joint balance was not correct after the withdraw", Double.toString(targetBalance), Double.toString(u.getJointBalance()));

	}
	
	@Test
	public void testViewBalance() {

		//test the viewBalance() function on all 3 bank account types

		//set up a test user to pass to viewBalance() with a balance of $100 in all 3 accounts
		User u = new User();
		u.setCheckingBalance(100);
		u.setSavingsBalance(100);
		u.setJointBalance(100);

		//set a string to pass to viewBalance() in order to choose which account to withdraw from
		String accountChosen;
		//set a target value for the users balance to be at when viewed
		double targetBalance = 100;

		//test the viewBalance() results against the targetBalance for checking
		accountChosen = "1";
		assertEquals("The users balance was not correct when viewed for checking", Double.toString(targetBalance), Double.toString(UserActions.viewBalance(accountChosen, u)));
		
		//test the viewBalance() results against the targetBalance for savings
		accountChosen = "2";
		assertEquals("The users balance was not correct when viewed for savings", Double.toString(targetBalance), Double.toString(UserActions.viewBalance(accountChosen, u)));

		//test the viewBalance() results against the targetBalance
		accountChosen = "3";
		assertEquals("The users balance was not correct when viewed for joint", Double.toString(targetBalance), Double.toString(UserActions.viewBalance(accountChosen, u)));

	}

}
