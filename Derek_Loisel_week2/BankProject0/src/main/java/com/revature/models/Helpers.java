package com.revature.models;

import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.dao.JointAccountDAO;
import com.revature.dao.JointAccountDAOImpl;
import com.revature.dao.UsersDAO;
import com.revature.dao.UsersDAOImpl;

public class Helpers {

	public static boolean balanceTooLow(String accountChosen, double amountToWithdraw, User user) {
		//checks if balance is too low to withdraw
		boolean balanceTooLow = false;

		if (accountChosen == "Checking") {
			if ((user.getCheckingBalance() - amountToWithdraw) < 0) {
				balanceTooLow = true;
			}
		}
		if(accountChosen == "Savings") {
			if((user.getSavingsBalance() - amountToWithdraw) < 0) {
				balanceTooLow = true;
			}
		}
		if(accountChosen == "Joint") {
			if((user.getJointBalance() - amountToWithdraw) < 0) {
				balanceTooLow = true;
			}
		}
		if(balanceTooLow) {
			return true;
		}else {
			return false;
		}
	}

	public static boolean accountExists(String accountChosen, User user) {
		//check if the chosen account exists for the user
		switch(accountChosen) {
		case "1":
			if (user.getHasCheckingAccount()) {
				return true;
			}else {
				System.out.println("You don't have a Checking Account!  Open an account to view your balance.");
				return false;
			}

		case"2":
			if (user.getHasSavingsAccount()) {
				return true;
			}else {
				System.out.println("You don't have a Savings Account!  Open an account to view your balance.");
				return false;
			}
		case"3":
			if (user.getHasJointAccount()) {
				return true;
			}
			else {
				System.out.println("You don't have a Joint Account!  Open an account to view your balance.");
				return false;
			}
			default:  
				System.out.println("Invalid input, please try again.");
				return false;
		}
	}

	public static User updateUserObject(User user) {

		// Calls DAO methods getUserByUsername(), getAccountByUserID(), and getJointAccountByUserID() to 
		// fill in the user object with updated data from the database
		
		UsersDAO usersDAO = new UsersDAOImpl();
		user = usersDAO.getUserByUsername(user);

		AccountDAO accountDAO = new AccountDAOImpl();
		Account account = new Account();
		account.setUserID(user.getUserID());
		Account a = accountDAO.getAccountByUserID(account);

		// set user objects account info
		user.setAccountID(a.getAccountID());
		user.setCheckingBalance(a.getCheckingBalance());
		user.setSavingsBalance(a.getSavingsBalance());

		if (a.getCheckingBalance() == -999999999) {
			user.setHasCheckingAccount(false);
		} else {
			user.setHasCheckingAccount(true);
		}

		if (a.getSavingsBalance() == -999999999) {
			// set users hasSavingsAccount to false
			user.setHasSavingsAccount(false);
		} else {
			// set users hasSavingsAccount to true
			user.setHasSavingsAccount(true);
		}

		// getJointAccountByUserID() to get the joint account matching the user id if a
		// joint account exists, checks both user1id and user2id for a match
		JointAccountDAO jointAccountDAO = new JointAccountDAOImpl();
		int userID = user.getUserID();
		JointAccount j = jointAccountDAO.getJointAccountByUserID(userID);

		// set user objects joint info
		user.setJointID(j.getJointID());
		user.setJointBalance(j.getJointBalance());

		if (j.getJointID() == 0) {

			// if the jointid IS 0, then hasJointAccount is false because no account exists
			user.setHasJointAccount(false);

		} else {

			// if the jointid is not 0, then hasJointAccount is true because an account
			// already exists
			// set user objects joint account info
			user.setHasJointAccount(true);
		}

		return user;
	}

	public static void updateAccountsInDatabase(String accountChosen, User user) {
		//calls method from AccountDAO or JointAccountDAO to update the database
		if ((accountChosen == "Checking") || (accountChosen == "Savings")) {
			// fill an account object to update the database
			Account a = new Account();
			a.setAccountID(user.getAccountID());
			a.setUserID(user.getUserID());
			a.setCheckingBalance(user.getCheckingBalance());
			a.setSavingsBalance(user.getSavingsBalance());
			AccountDAO accountDAO = new AccountDAOImpl();
			accountDAO.updateAccount(a);
		} else {
			// update the joint balance in the database
			int jointID = user.getJointID();
			double newBalance = user.getJointBalance();
			JointAccountDAO jointDAO = new JointAccountDAOImpl();
			jointDAO.updateJointBalanceByJointID(jointID, newBalance);
		}
	}
}
