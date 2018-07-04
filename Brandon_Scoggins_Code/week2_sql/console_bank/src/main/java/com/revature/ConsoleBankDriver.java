package com.revature;

import com.revature.dao.AccountsDAO;
import com.revature.dao.AccountsDAOImpl;
import com.revature.dao.CheckingAccountDAO;
import com.revature.dao.CheckingDAOImpl;
import com.revature.dao.SavingsAccountDAO;
import com.revature.dao.SavingsDAOImpl;
import com.revature.dao.TransactionDAO;
import com.revature.dao.TransactionDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.Account;
import com.revature.models.CheckingAccount;
import com.revature.models.SavingsAccount;
import com.revature.models.Transaction;
import com.revature.models.User;

public class ConsoleBankDriver {

	public static void main(String[] args) {
		
		System.out.println("connecting..");
		UserDAO userDAO = new UserDAOImpl();
		AccountsDAO accountsDAO = new AccountsDAOImpl();
		CheckingAccountDAO checkingDAO = new CheckingDAOImpl();
		SavingsAccountDAO savingsDAO = new SavingsDAOImpl();
		TransactionDAO transactionDAO = new TransactionDAOImpl();
		
		System.out.println("\ngetting all users");
		for(User userInDB : userDAO.getAllUsers()) {
			System.out.println(userInDB.toString());
		}
		
		User bob = new User(1, "bob", "bill", "bobBill", "isgreat", "bob@bill.com");
		User joe = new User(1, "joe", "bill", "joeBill", "iscool", "joe@bill.com");
		User sue = new User(1, "sue", "bill", "sueBill", "isfine", "sue@bill.com");
		
//		System.out.println("\ncreate new user");
//		
//		userDAO.createUser(bob);
//		userDAO.createUser(joe);
		userDAO.createUser(sue);
		
		System.out.println("\ngetting all users");
		for(User userInDB : userDAO.getAllUsers()) {
			System.out.println(userInDB.toString());
		}
		
		System.out.println("\ngetting all accounts");
		for(Account accountsInDB : accountsDAO.getAllAccounts()) {
			System.out.println(accountsInDB.toString());
		}
		
//		System.out.println("deleting bob");
//		userDAO.deleteUser(bob);
//		
//		System.out.println("getting all users (expect empty)");
//		for(User userInDB : userDAO.getAllUsers()) {
//			System.out.println(userInDB.toString());
//		}
		
		System.out.println("\nLogging in with userName: sueBill and passWord: isfine...\n");
		User activeUser = userDAO.logInUser("sueBill", "isfine");
		System.out.println("\nLogged in: " + activeUser.toString());
		
//		activeUser.setEmail("Bob@bill.com");
//		
//		userDAO.updateUser(activeUser);
//		System.out.println("getting all users ");
//		for(User userInDB : userDAO.getAllUsers()) {
//			System.out.println(userInDB.toString());
//		}
		
		System.out.println("\nList all acount-user access priveledges for sue...");
		for(User userInDB : accountsDAO.getAllAccountUsers(activeUser)) {
			System.out.println(userInDB.toString());
		}
		
		// add logic to see if user is already authorized before attempting to authorize
		accountsDAO.authorizeUser(activeUser, activeUser.getUserId());		// argument 2 is a local user id as of testing
		
		System.out.println("\nList all account-user access privileges for bob...");
		for(User userInDB : accountsDAO.getAllAccountUsers(activeUser)) {
			System.out.println(userInDB.toString());
		}
		
		
		System.out.println("\n------------------------\n------------------------\n");
		
		System.out.println("\nList all checking accounts...");
		for(CheckingAccount userInDB : checkingDAO.getAllCheckingAccounts()) {
			System.out.println(userInDB.toString());
		}
		
		checkingDAO.createChecking(activeUser);
//		checkingDAO.pairCheckingToAccount(activeUser);
		
		System.out.println("\nList all checking accounts...");
		for(CheckingAccount userInDB : checkingDAO.getAllCheckingAccounts()) {
			System.out.println(userInDB.toString());
		}
		
		System.out.println("The checking balance is: " + checkingDAO.getCheckingBalanceByAccountId(accountsDAO.getAccountIdByUser(activeUser)));
		
		checkingDAO.depositChecking(activeUser, accountsDAO.getAccountIdByUser(activeUser), 12.00);
		
		System.out.println("The checking balance is: " + checkingDAO.getCheckingBalanceByUser(activeUser));
		
		checkingDAO.withdrawChecking(activeUser, accountsDAO.getAccountIdByUser(activeUser), 12.00);
		
		System.out.println("The checking balance is: " + checkingDAO.getCheckingBalanceByUser(activeUser));
		
//		checkingDAO.deleteChecking(activeUser);
//		
//		System.out.println("List all checking accounts...");
//		for(CheckingAccount userInDB : checkingDAO.getAllCheckingAccounts()) {
//			System.out.println(userInDB.toString());
//		}
//		
		
		
		System.out.println("\n------------------------\n------------------------\n");
		
		System.out.println("\nList all savings accounts...");
		for(SavingsAccount userInDB : savingsDAO.getAllSavingsAccounts()) {
			System.out.println(userInDB.toString());
		}
		
		savingsDAO.createSavings(activeUser);
//		savingsDAO.pairSavingsToAccount(activeUser);
		
		System.out.println("\nList all savings accounts...");
		for(SavingsAccount userInDB : savingsDAO.getAllSavingsAccounts()) {
			System.out.println(userInDB.toString());
		}
		
		System.out.println("The savings balance is: " + savingsDAO.getSavingsBalanceByAccountId(accountsDAO.getAccountIdByUser(activeUser)));
		
		savingsDAO.depositSavings(activeUser, accountsDAO.getAccountIdByUser(activeUser), 12.00);
		
		System.out.println("The savings balance is: " + savingsDAO.getSavingsBalanceByUser(activeUser));
		
		savingsDAO.withdrawSavings(activeUser, accountsDAO.getAccountIdByUser(activeUser), 12.00);
		
		System.out.println("The savings balance is: " + savingsDAO.getSavingsBalanceByUser(activeUser));
		
		System.out.println("\n------------------------\n------------------------\n");
		
		transactionDAO.recordTransaction(activeUser, "Checking", 4, null, 55.00);				// test withdraw
		transactionDAO.recordTransaction(activeUser, null, 54, "Savings", 65.00);				// test deposit
		transactionDAO.recordTransaction(activeUser, "Checking", 54, "Checking", 75.00);		// test transfer
		
		System.out.println("\nList all transactions for current user's acount...");
		for(Transaction userInDB : transactionDAO.getAccountTransactions(activeUser)) {
			System.out.println(userInDB.toString());
		}
		
		System.out.println("\nList transactions on current user's account by the current user...");
		for(Transaction userInDB : transactionDAO.getTransactionsByUserId(activeUser, activeUser.getUserId())) {
			System.out.println(userInDB.toString());
		}
		
		System.out.println("\nList transactions on current user's account by the user 59...");
		for(Transaction userInDB : transactionDAO.getTransactionsByUserId(activeUser, 59)) {
			System.out.println(userInDB.toString());
		}
	}
	
	// a logout method to update userDB with current active user (and associated accounts) then set active user to null
}
