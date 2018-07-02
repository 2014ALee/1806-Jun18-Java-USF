package com.revature;

import com.revature.dao.AccountsDAO;
import com.revature.dao.AccountsDAOImpl;
import com.revature.dao.CheckingAccountDAO;
import com.revature.dao.CheckingDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.Account;
import com.revature.models.CheckingAccount;
import com.revature.models.User;

public class ConsoleBankDriver {

	public static void main(String[] args) {
		
		System.out.println("connecting..");
		UserDAO userDAO = new UserDAOImpl();
		AccountsDAO accountsDAO = new AccountsDAOImpl();
		CheckingAccountDAO checkingDAO = new CheckingDAOImpl();
		
		System.out.println("\ngetting all users");
		for(User userInDB : userDAO.getAllUsers()) {
			System.out.println(userInDB.toString());
		}
		
		User bob = new User(1, "bob", "bill", "bobBill", "isgreat", "bob@bill.com");
		User joe = new User(1, "joe", "bill", "joeBill", "iscool", "joe@bill.com");
		User sue = new User(1, "sue", "bill", "sueBill", "isfine", "sue@bill.com");
		
		System.out.println("\ncreate new user");
		
		userDAO.createUser(bob);
//		userDAO.createUser(joe);
//		userDAO.createUser(sue);
		
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
		
		System.out.println("\nLogging in with userName: bobBill and passWord: isgreat...\n");
		User activeUser = userDAO.logInUser("bobBill", "isgreat");
		System.out.println("\nLogged in: " + activeUser.toString());
		
//		activeUser.setEmail("Bob@bill.com");
//		
//		userDAO.updateUser(activeUser);
//		System.out.println("getting all users ");
//		for(User userInDB : userDAO.getAllUsers()) {
//			System.out.println(userInDB.toString());
//		}
		
		System.out.println("\nList all acount-user access priveledges for bob...");
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
		
		System.out.println(checkingDAO.getCheckingBalance(activeUser));
		
		
		
		
//		checkingDAO.deleteChecking(activeUser);
//		
//		System.out.println("List all checking accounts...");
//		for(CheckingAccount userInDB : checkingDAO.getAllCheckingAccounts()) {
//			System.out.println(userInDB.toString());
//		}
//		
	}
	
	// a logout method to update userDB with current active user (and associated accounts) then set active user to null
}
