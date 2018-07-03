package com.revature.models;

public class UserActions {

	public static double viewBalance(String accountChosen, User user) {

		double balance = 0;

		switch (accountChosen) {
		case "1":			
				balance = user.getCheckingBalance();
				System.out.println("Your current Checking Account balance is: " + balance);		
			break;
		case "2":
				balance = user.getSavingsBalance();
				System.out.println("Your current Savings Account balance is: " + balance);
			break;
		case "3":
				balance = user.getJointBalance();
				System.out.println("Your current Joint Account balance is: " + balance);
			break;
		}

		return balance;
	}
	
	public static User withdraw(String accountChosen, double amountToWithdraw, User user) {
		
		// subtract the amount of withdrawal from the users current balance
		if (accountChosen == "Checking") {
				user.setCheckingBalance(user.getCheckingBalance() - amountToWithdraw);
		} else if (accountChosen == "Savings") {
				user.setSavingsBalance(user.getSavingsBalance() - amountToWithdraw);
		} else {// account chosen == "Joint"
				user.setJointBalance(user.getJointBalance() - amountToWithdraw);
		}

		System.out.println("Withdrawal successful!  You withdrew $" + amountToWithdraw + " from your "
				+ accountChosen + " account!");
		
		return user;
	}
	
	public static User deposit(String accountChosen, double amountToDeposit, User user) {

		// add the amount of deposit to the users current balance
		if (accountChosen == "Checking") {
			user.setCheckingBalance(user.getCheckingBalance() + amountToDeposit);
		} else if (accountChosen == "Savings") {
			user.setSavingsBalance(user.getSavingsBalance() + amountToDeposit);
		} else {
			user.setJointBalance(user.getJointBalance() + amountToDeposit);
		}

		System.out.println("Deposit successful!  You deposited $" + amountToDeposit + " into your " + accountChosen
				+ " account!");

		return user;
	}
	
}
