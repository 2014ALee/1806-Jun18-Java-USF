package com.revature;

import static org.hamcrest.CoreMatchers.notNullValue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Set;

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
import com.revature.models.User;

public class BankUserInterfaceDriver {

	static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
	
	static UserDAO userDAO = new UserDAOImpl();
	static AccountsDAO accountsDAO = new AccountsDAOImpl();
	static CheckingAccountDAO checkingDAO = new CheckingDAOImpl();
	static SavingsAccountDAO savingsDAO = new SavingsDAOImpl();
	static TransactionDAO transactionDAO = new TransactionDAOImpl();
	
	public static void main(String[] args) {
		
		displayUnLoggedInMenu();
	}

	public static void displayWelcome() {

		System.out.println("--Welcome to Console Bank!--");
	}

	public static void displayWelcome(String name) {

		System.out.println("-Welcome, " + name + ", to Console Bank!-");
	}
	
	public static void displayUnLoggedInMenu() {
		
		String input = null;

		displayWelcome();
		
		System.out.println("---------------------------------");
		System.out.println("|          Welcome Menu         |");
		System.out.println("---------------------------------");
		System.out.println("| [1] - Log In                  |");
		System.out.println("| [2] - Register New User       |");
		System.out.println("| [3] - Quit                    |");
		System.out.println("---------------------------------");
		do {
			input = getMenuInput();			
			if(!input.equals("1") && !input.equals("2") && !input.equals("3"))
				System.out.println("\nPlease enter a valid menu option.");
		}while(!input.equals("1") && !input.equals("2") && !input.equals("3"));

		System.out.println();

		switch(input) {
		case "1":
			logInUser();
			break;
		case "2":
			registerNewUser();
			break;
		case "3":
			System.out.println("Thank you for using Console Bank!");
			System.exit(0);
			break;
		default:
			System.out.println("Un-anticipated error in displayUnLoggedInMenu()");
			System.exit(0);				
		}
	}

	public static void displayLoggedInMenu(User activeUser, int activeAccountId) {
		
		String input = null;
		
		displayWelcome(activeUser.getFirstName());
		
		System.out.println("---------------------------------");
		System.out.println("|          Welcome Menu         |");
		System.out.println("---------------------------------");
		System.out.println("| Would you like to work with.. |");
		System.out.println("| [1] - Checking Account        |");
		System.out.println("| [2] - Savings Account         |");
		System.out.println("| [3] - Access Another Account  |");
		System.out.println("| [4] - Transaction History     |");
		System.out.println("| [5] - Account Access          |");
		System.out.println("| [6] - User Information        |");
		System.out.println("| [7] - Log Out                 |");
		System.out.println("| [8] - Quit                    |");
		System.out.println("---------------------------------");
		do {	
			input = getMenuInput();	
			if(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5") && !input.equals("6") && !input.equals("7") && !input.equals("8"))
				System.out.println("\nPlease enter a valid menu option.");
		}while(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5") && !input.equals("6") && !input.equals("7") && !input.equals("8"));

		System.out.println();

		switch(input) {
		case "1":
			if(checkingAccountExist(activeUser, activeAccountId)) {
				checkingAccountMenu(activeUser, activeAccountId);
			}else {
				displayLoggedInMenu(activeUser, activeAccountId);
			}
			
			break;
		case "2":
			if(savingsAccountExist(activeUser, activeAccountId)) {
				savingsAccountMenu(activeUser, activeAccountId);
			}else {
				displayLoggedInMenu(activeUser, activeAccountId);
			}
			
			break;
		case "3":
			accessAnotherAccount(activeUser, activeAccountId);
			break;
		case "4":
			transactionHistoryMenu(activeUser, activeAccountId);
			break;
		case "5":
			accountAccessMenu(activeUser, activeAccountId);
			break;
		case "6":
			userInformationMenu(activeUser);
			break;
		case "7":
			logOutUser();
			break;
		case "8":
			System.out.println("Thank you for using Console Bank!");
			System.exit(0);
			break;
		default:
			System.out.println("Un-anticipated error in displayLoggedInMenu()");
			System.exit(0);				
		}
	}
	
	public static boolean checkingAccountExist(User activeUser, int activeAccountId) {

		String input = null;
		
		if(accountsDAO.getAccountCheckingId(activeAccountId) == 0) {
			System.out.println("This account does not have a checking account.");
			
			if(activeUser.getUserId() == accountsDAO.getAccountHolderId(activeAccountId)) {
				System.out.println("Would you like to create one? ['1' for yes | '2' for no]");

				do {	
					input = getMenuInput();	
					if(!input.equals("1") && !input.equals("2"))
						System.out.println("\nPlease enter a valid option.");
				}while(!input.equals("1") && !input.equals("2"));

				System.out.println();

				if(input.equals("1")) {
					checkingDAO.createChecking(activeUser);
					return true;
				}else if (input.equals("2")) {
					return false;
				}
			}else {
				System.out.println("The account holder may create one.");
				return false;
			}
		}else {
			return true;
		}
		
		return false;
	}

	public static boolean savingsAccountExist(User activeUser, int activeAccountId) {

		String input = null;
		
		if(accountsDAO.getAccountSavingsId(activeAccountId) == 0) {
			System.out.println("This account does not have a savings account.");
			
			if(activeUser.getUserId() == accountsDAO.getAccountHolderId(activeAccountId)) {
				System.out.println("Would you like to create one? ['1' for yes | '2' for no]");

				do {	
					input = getMenuInput();	
					if(!input.equals("1") && !input.equals("2"))
						System.out.println("\nPlease enter a valid option.");
				}while(!input.equals("1") && !input.equals("2"));

				System.out.println();

				if(input.equals("1")) {
					savingsDAO.createSavings(activeUser);
					return true;
				}else if (input.equals("2")) {
					return false;
				}
			}else {
				System.out.println("The account holder may create one.");
				return false;
			}
		}else {
			return true;
		}
		
		return false;
	}
	
	public static void checkingAccountMenu(User activeUser, int activeAccountId) {
		
		String input = null;
		
		System.out.println("---------------------------------");
		System.out.println("|     Checking Account Menu     |");
		System.out.println("---------------------------------");
		System.out.println("| Would you like to..           |");
		System.out.println("| [1] - View Checking Balance   |");
		System.out.println("| [2] - Deposit To Checking     |");
		System.out.println("| [3] - Withdraw From Checking  |");
		System.out.println("| [4] - Transfer From Checking  |");
		System.out.println("| [5] - Return To Welcome Menu  |");
		System.out.println("| [6] - Log Out                 |");
		System.out.println("| [7] - Quit                    |");
		System.out.println("---------------------------------");
		do {	
			input = getMenuInput();	
			if(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5") && !input.equals("6") && !input.equals("7"))
				System.out.println("\nPlease enter a valid menu option.");
		}while(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5") && !input.equals("6") && !input.equals("7"));

		System.out.println();

		switch(input) {
		case "1":
			viewCheckingBalance(activeUser, activeAccountId);
			break;
		case "2":
			depositToChecking(activeUser, activeAccountId);
			break;
		case "3":
			withdrawFromChecking(activeUser, activeAccountId);
			break;
		case "4":
			transferFromChecking(activeUser, activeAccountId);
			break;
		case "5":
			displayLoggedInMenu(activeUser, activeAccountId);
			break;
		case "6":
			logOutUser();
			break;
		case "7":
			System.out.println("Thank you for using Console Bank!");
			System.exit(0);
			break;
		default:
			System.out.println("Un-anticipated error in displayLoggedInMenu()");
			System.exit(0);				
		}
	}
	
	public static void savingsAccountMenu(User activeUser, int activeAccountId) {

		String input = null;

		System.out.println("---------------------------------");
		System.out.println("|      Savings Account Menu     |");
		System.out.println("---------------------------------");
		System.out.println("| Would you like to..           |");
		System.out.println("| [1] - View Savings Balance    |");
		System.out.println("| [2] - Deposit To Savings      |");
		System.out.println("| [3] - Withdraw From Savings   |");
		System.out.println("| [4] - Transfer From Savings   |");
		System.out.println("| [5] - Return To Welcome Menu  |");
		System.out.println("| [6] - Log Out                 |");
		System.out.println("| [7] - Quit                    |");
		System.out.println("---------------------------------");
		do {	
			input = getMenuInput();	
			if(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5") && !input.equals("6") && !input.equals("7"))
				System.out.println("\nPlease enter a valid menu option.");
		}while(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5") && !input.equals("6") && !input.equals("7"));

		System.out.println();

		switch(input) {
		case "1":
			viewSavingsBalance(activeUser, activeAccountId);
			break;
		case "2":
			depositToSavings(activeUser, activeAccountId);
			break;
		case "3":
			withdrawFromSavings(activeUser, activeAccountId);
			break;
		case "4":
			transferFromSavings(activeUser, activeAccountId);
			break;
		case "5":
			displayLoggedInMenu(activeUser, activeAccountId);
			break;
		case "6":
			logOutUser();
			break;
		case "7":
			System.out.println("Thank you for using Console Bank!");
			System.exit(0);
			break;
		default:
			System.out.println("Un-anticipated error in displayLoggedInMenu()");
			System.exit(0);				
		}
	}
	
	public static void accessAnotherAccount(User activeUser, int activeAccountId) {
		
		String input = null;
		boolean accountAccessGranted = false;
		
		System.out.println("Which account do you want to access?");
		System.out.print("Account Id: 		");
		input = getIntInput();
		int intInput = Integer.parseInt(input);
		System.out.println(intInput);
		
		ArrayList<User> authorizedUsers = new ArrayList<>();
		authorizedUsers = accountsDAO.getAllAccountUsers(intInput);
		
		if(authorizedUsers.isEmpty()) {
			System.out.println("That account does not exist.");
		}else {
			for(User authorizedUser : authorizedUsers) {
				if(authorizedUser.getUserId() == activeUser.getUserId()) {
					System.out.println("Access granted!");
					accountAccessGranted = true;
				}
			}
		}
		
		if(accountAccessGranted) {
			displayLoggedInMenu(activeUser, intInput);
		} else {
			System.out.println("You are not authorized to that account.");
			displayLoggedInMenu(activeUser);
		}
	}
	
	public static void transactionHistoryMenu(User activeUser, int activeAccountId) {
		
		String input = null;
		
		System.out.println("---------------------------------");
		System.out.println("|   Transaction History Menu    |");
		System.out.println("---------------------------------");
		System.out.println("| Would you like to view..      |");
		System.out.println("| [1] - All Transactions        |");
		System.out.println("| [2] - Your Transactions       |");
		System.out.println("| [3] - Transactions By User Id |");
		System.out.println("| [4] - Return To Welcome Menu  |");
		System.out.println("| [5] - Log Out                 |");
		System.out.println("| [6] - Quit                    |");
		System.out.println("---------------------------------");
		do {	
			input = getMenuInput();	
			if(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5") && !input.equals("6"))
				System.out.println("\nPlease enter a valid menu option.");
		}while(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5") && !input.equals("6"));

		System.out.println();

		switch(input) {
		case "1":
			viewAllTransactions(activeUser, activeAccountId);
			break;
		case "2":
			viewYourTransactions(activeUser, activeAccountId);		// case 2 and 3 point to same method, but case 3 goes through another method to get userid first
			break;									// similar to access another account mehthod
		case "3":
			viewTransactionsByUserId(activeUser, activeAccountId);
			break;
		case "4":
			displayLoggedInMenu(activeUser, activeAccountId);
			break;
		case "5":
			logOutUser();
			break;
		case "6":
			System.out.println("Thank you for using Console Bank!");
			System.exit(0);
			break;
		default:
			System.out.println("Un-anticipated error in displayLoggedInMenu()");
			System.exit(0);				
		}
	}
	
	public static void accountAccessMenu(User activeUser, int activeAccountId) {
		
		String input = null;
		
		System.out.println("---------------------------------");
		System.out.println("|      Account Access Menu      |");
		System.out.println("---------------------------------");
		System.out.println("| Would you like to..           |");
		System.out.println("| [1] - View Authorized Users   |");
		System.out.println("| [2] - Authorize A User        |");
		System.out.println("| [3] - Deauthorize A User      |");
		System.out.println("| [4] - Return To Welcome Menu  |");
		System.out.println("| [5] - Log Out                 |");
		System.out.println("| [6] - Quit                    |");
		System.out.println("---------------------------------");
		do {	
			input = getMenuInput();	
			if(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5") && !input.equals("6"))
				System.out.println("\nPlease enter a valid menu option.");
		}while(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5") && !input.equals("6"));

		System.out.println();

		switch(input) {
		case "1":
			viewAuthorizedUsers(activeUser, activeAccountId);
			break;
		case "2":
			authorizeUser(activeUser, activeAccountId);
			break;
		case "3":
			deauthorizeUser(activeUser, activeAccountId);
			break;
		case "4":
			displayLoggedInMenu(activeUser, activeAccountId);
			break;
		case "5":
			logOutUser();
			break;
		case "6":
			System.out.println("Thank you for using Console Bank!");
			System.exit(0);
			break;
		default:
			System.out.println("Un-anticipated error in displayLoggedInMenu()");
			System.exit(0);				
		}
	}
	
	public static void userInformationMenu(User activeUser) {
		
		String input = null;
		
		System.out.println("---------------------------------");
		System.out.println("|     User Information Menu     |");
		System.out.println("---------------------------------");
		System.out.println("| Would you like to..           |");
		System.out.println("| [1] - View User Id            |");
		System.out.println("| [2] - Update First Name       |");
		System.out.println("| [3] - Update Last Name        |");
		System.out.println("| [4] - Update User Name        |");
		System.out.println("| [5] - Update Password         |");
		System.out.println("| [6] - Update Email            |");
		System.out.println("| [7] - Return To Welcome Menu  |");
		System.out.println("| [8] - Log Out                 |");
		System.out.println("| [9] - Quit                    |");
		System.out.println("---------------------------------");
		do {	
			input = getMenuInput();	
			if(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5") && !input.equals("6") && !input.equals("7") && !input.equals("8") && !input.equals("9"))
				System.out.println("\nPlease enter a valid menu option.");
		}while(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5") && !input.equals("6") && !input.equals("7") && !input.equals("8") && !input.equals("9"));

		System.out.println();

		switch(input) {					// these will mostly point to the same place but go through a method to get the update piece of information
		case "1":
			viewUserId(activeUser);
			break;
		case "2":
			updateFirstName(activeUser);
			break;
		case "3":
			updateLastName(activeUser);
			break;
		case "4":
			updateUserName(activeUser);
			break;
		case "5":
			updatePassWord(activeUser);
			break;
		case "6":
			updateEmail(activeUser);
			break;
		case "7":
			displayLoggedInMenu(activeUser);
			break;
		case "8":
			logOutUser();
			break;
		case "9":
			System.out.println("Thank you for using Console Bank!");
			System.exit(0);
			break;
		default:
			System.out.println("Un-anticipated error in displayLoggedInMenu()");
			System.exit(0);				
		}
	}
	
	public static void viewCheckingBalance(User activeUser, int activeAccountId) {
		
		System.out.println("Current Balance: $" + checkingDAO.getCheckingBalanceByAccountId(activeAccountId));
		System.out.println();
		
		checkingAccountMenu(activeUser, activeAccountId);
	}
	
	public static void depositToChecking(User activeUser, int activeAccountId) {

		System.out.println("Deposit Amount: ");

		double depositAmount = getCashInput();

		checkingDAO.depositChecking(activeUser, activeAccountId, depositAmount);
		transactionDAO.recordTransaction(activeUser, 0, null, activeAccountId, "Checking", depositAmount);

		System.out.println();
		viewCheckingBalance(activeUser, activeAccountId);
	}

	public static void withdrawFromChecking(User activeUser, int activeAccountId) {

		System.out.println("Withdraw Amount: ");

		double withdrawAmount = getCashInput();

		if(withdrawAmount > checkingDAO.getCheckingBalanceByAccountId(activeAccountId)) {
			System.out.println("\nCannot withdraw more money than is in the account.\n");
		}else {
			checkingDAO.withdrawChecking(activeUser, activeAccountId, withdrawAmount);
			transactionDAO.recordTransaction(activeUser, activeAccountId, "Checking", 0, null, withdrawAmount);
		}
		System.out.println();

		viewCheckingBalance(activeUser, activeAccountId);
	}

	public static void transferFromChecking(User activeUser, int activeAccountId) {

		String targetAccountId = null;
		String targetAccountType = null;
		boolean targetAccountExist = false;
		boolean targetAccountTypeExist = false;

		System.out.println("Which account do you want to transfer funds to?");
		System.out.print("Account Id: 		");
		targetAccountId = getIntInput();
		int intInput = Integer.parseInt(targetAccountId);
		System.out.println(intInput);
		
		System.out.println("Which account type ['1' for checking | '2' for checking] do you want to transfer funds to?");
		System.out.print("Account Type: 		");
		
		do {	
			targetAccountType = getMenuInput();
			if(!targetAccountType.equals("1") && !targetAccountType.equals("2"))
				System.out.println("\nPlease enter a valid menu option.");
		}while(!targetAccountType.equals("1") && !targetAccountType.equals("2"));

		System.out.println();

		ArrayList<Account> existingAccounts = new ArrayList<>();
		existingAccounts = accountsDAO.getAllAccounts();

		for(Account account : existingAccounts) {
			if(account.getAccountId() == intInput) {
				targetAccountExist = true;
				if(targetAccountType.equals("1")) {
					if(accountsDAO.getAccountCheckingId(intInput) != 0) {
						targetAccountTypeExist = true;
						targetAccountType = "Checking";
					}
				}else {
					if(accountsDAO.getAccountCheckingId(intInput) != 0){
						targetAccountTypeExist = true;
						targetAccountType = "Checking";
					}
				}
				break;
			}
		}

		if (!targetAccountExist) {
			System.out.println("That account does not exist.");
			checkingAccountMenu(activeUser, activeAccountId);
		}else if(!targetAccountTypeExist){
			System.out.println("Target account type does not exist.");
			checkingAccountMenu(activeUser, activeAccountId);
		}else {
			
			System.out.println("Transfer Amount: ");

			double transferAmount = getCashInput();

			if(transferAmount > checkingDAO.getCheckingBalanceByAccountId(activeAccountId)) {
				System.out.println("\nCannot transfer more money than is in the account.\n");
				checkingAccountMenu(activeUser, activeAccountId);
			}else {
				checkingDAO.withdrawChecking(activeUser, activeAccountId, transferAmount);

				checkingDAO.depositChecking(activeUser, intInput, transferAmount);

				transactionDAO.recordTransaction(activeUser, activeAccountId, "Checking", intInput, targetAccountType, transferAmount);
				
				System.out.println();

				viewCheckingBalance(activeUser, activeAccountId);
			}
		}	
	}

	public static void viewSavingsBalance(User activeUser, int activeAccountId) {

		System.out.println("Current Balance: $" + savingsDAO.getSavingsBalanceByAccountId(activeAccountId));
		System.out.println();

		savingsAccountMenu(activeUser, activeAccountId);
	}

	public static void depositToSavings(User activeUser, int activeAccountId) {

		System.out.println("Deposit Amount: ");

		double depositAmount = getCashInput();

		savingsDAO.depositSavings(activeUser, activeAccountId, depositAmount);
		transactionDAO.recordTransaction(activeUser, 0, null, activeAccountId, "Savings", depositAmount);

		System.out.println();
		viewSavingsBalance(activeUser, activeAccountId);
	}

	public static void withdrawFromSavings(User activeUser, int activeAccountId) {

		System.out.println("Withdraw Amount: ");

		double withdrawAmount = getCashInput();

		if(withdrawAmount > savingsDAO.getSavingsBalanceByAccountId(activeAccountId)) {
			System.out.println("\nCannot withdraw more money than is in the account.\n");
		}else {
			savingsDAO.withdrawSavings(activeUser, activeAccountId, withdrawAmount);
			transactionDAO.recordTransaction(activeUser, activeAccountId, "Savings", 0, null, withdrawAmount);
		}
		System.out.println();

		viewSavingsBalance(activeUser, activeAccountId);
	}

	public static void transferFromSavings(User activeUser, int activeAccountId) {

		String targetAccountId = null;
		String targetAccountType = null;
		boolean targetAccountExist = false;
		boolean targetAccountTypeExist = false;

		System.out.println("Which account do you want to transfer funds to?");
		System.out.print("Account Id: 		");
		targetAccountId = getIntInput();
		int intInput = Integer.parseInt(targetAccountId);
		System.out.println(intInput);
		
		System.out.println("Which account type ['1' for checking | '2' for savings] do you want to transfer funds to?");
		System.out.print("Account Type: 		");
		
		do {	
			targetAccountType = getMenuInput();
			if(!targetAccountType.equals("1") && !targetAccountType.equals("2"))
				System.out.println("\nPlease enter a valid menu option.");
		}while(!targetAccountType.equals("1") && !targetAccountType.equals("2"));

		System.out.println();

		ArrayList<Account> existingAccounts = new ArrayList<>();
		existingAccounts = accountsDAO.getAllAccounts();

		for(Account account : existingAccounts) {
			if(account.getAccountId() == intInput) {
				targetAccountExist = true;
				if(targetAccountType.equals("1")) {
					if(accountsDAO.getAccountCheckingId(intInput) != 0) {
						targetAccountTypeExist = true;
						targetAccountType = "Checking";
					}
				}else {
					if(accountsDAO.getAccountSavingsId(intInput) != 0){
						targetAccountTypeExist = true;
						targetAccountType = "Savings";
					}
				}
				break;
			}
		}

		if (!targetAccountExist) {
			System.out.println("That account does not exist.");
			savingsAccountMenu(activeUser, activeAccountId);
		}else if(!targetAccountTypeExist){
			System.out.println("Target account type does not exist.");
			savingsAccountMenu(activeUser, activeAccountId);
		}else {
			
			System.out.println("Transfer Amount: ");

			double transferAmount = getCashInput();

			if(transferAmount > savingsDAO.getSavingsBalanceByAccountId(activeAccountId)) {
				System.out.println("\nCannot transfer more money than is in the account.\n");
				savingsAccountMenu(activeUser, activeAccountId);
			}else {
				savingsDAO.withdrawSavings(activeUser, activeAccountId, transferAmount);

				savingsDAO.depositSavings(activeUser, intInput, transferAmount);

				transactionDAO.recordTransaction(activeUser, activeAccountId, "Savings", intInput, targetAccountType, transferAmount);
				
				System.out.println();

				viewSavingsBalance(activeUser, activeAccountId);
			}
		}	
	}

	public static void logOutUser() {
		
		System.out.println("Log Out Successful");
		System.out.println();
		
		displayUnLoggedInMenu();
	}

	public static void registerNewUser() {

		boolean isUnique = true;
		String userName = null;
		String email = null;
		String passWord = null;
		
		System.out.println("To register a new user, please enter a username, email address and password\n");
		
		System.out.println("Username: ");
		userName = getStringInput();

		if (userDAO.userExist(userName)) {
			System.out.println("\nThat username already exist. Please try again.\n");	 		
			isUnique = false;
		}else {
			System.out.println("\nThat username is available.\n");
		}

		if(!isUnique)
			displayUnLoggedInMenu();
		
		System.out.println("Email: ");
		email = getStringInput();

		if (userDAO.userExist(email)) {
			System.out.println("\nThat email already exist. Please try again.\n");	 		
			isUnique = false;
		}else {
			System.out.println("\nThat email is available.\n");
		}

		if(!isUnique)
			displayUnLoggedInMenu();

		do {
			System.out.println("Password: ");
			passWord = getStringInput();
			System.out.println("Confirm Password: ");
			if (!passWord.equals(getStringInput()))
				System.out.println("\nPasswords do not match. Try again.\n");
			else
				break;
		}while(true);

		System.out.println();

		System.out.println("Registration Successful!");
		System.out.println("Please update your user information at your convenience.");
		
		User newUser = new User(1, " ", " ", userName, passWord, email);
		userDAO.createUser(newUser);
		
		System.out.println();		
		displayUnLoggedInMenu();
	}

	public static void logInUser() {

		System.out.println("To login, please enter a username/email and password\n");

		System.out.println("Username/email: ");
		String userNameOrEmail = getStringInput();
		System.out.println("Password: ");
		String passWord = getStringInput();
		
		User activeUser = null;
		
		activeUser = userDAO.logInUser(userNameOrEmail, passWord);
		
		if (activeUser.equals(null)) {
			System.out.println("\nThat information is not in our database.\n");
			displayUnLoggedInMenu();
		}

		System.out.println();
		System.out.println("Login Successful!");
		System.out.println();
		
		displayLoggedInMenu(activeUser, accountsDAO.getAccountIdByUser(activeUser));
	}
	
	public static double getCashInput() {
		
		boolean validInput = true;
		
		System.out.println();
		System.out.println("Enter a cash value (##.##)");
		String input = getStringInput();
		char[] charInputArray = input.toCharArray();
		if(charInputArray.length == 0) {
			System.out.println("\nNo input was entered. Try again.");
			getCashInput();
		}else if(charInputArray.length < 3) {	
			System.out.println("\nInput too short. Please try again.");
			getCashInput();
		}else if(charInputArray[charInputArray.length - 3] != '.') {		
			System.out.println("\nIncorrect format. Please try again.");
			getCashInput();
		}else if(charInputArray[0] == '-') {
			System.out.println("\nCannot enter a negative amount.");
			getCashInput();
		}else {
			for(int i = 0; i < charInputArray.length; i++) {
				if (i != (charInputArray.length - 3)) {
					if(!charIsNumber(charInputArray[i])) {
						System.out.println(input);
						System.out.println("\nInput must be a number. Please Try again.");
						validInput = false;
						break;
					}
				}
			}
			if (!validInput) {
				getCashInput();
			}
		}
		return Double.parseDouble(input);
	}

	public static boolean charIsNumber(char character) {
		switch(character) {
		case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
			return true;
		default:
			return false;
		}
	}

	public static String getMenuInput() {
		String stringInput = getStringInput();
		boolean isIntInput = true;
		if(stringInput.length() == 0) {
			System.out.println("\nNo input was entered. Try again.");
			stringInput = null;
			isIntInput = false;
		}else if(stringInput.length() > 1) {
			System.out.println("\nInput too long. Please try again.");
			stringInput = null;
			isIntInput = false;
		}else if(!stringIsNumber(stringInput)) {
			System.out.println("\nInput must be a number. Please try again.");
			stringInput = null;
			isIntInput = false;
		}

		if(!isIntInput) {
			stringInput = "";
			getMenuInput();
		}
		return stringInput;
	}
	
	public static String getIntInput() {
		String stringInput = getStringInput();
		boolean isIntInput = true;
		if(stringInput.length() == 0) {
			System.out.println("\nNo input was entered. Try again.");
			stringInput = null;
			isIntInput = false;
		}else if(stringInput.length() > 10) {
			System.out.println("\nInput too long. Please try again.");
			stringInput = null;
			isIntInput = false;
		}else if(!stringIsNumber(stringInput)) {
			System.out.println("\nInput must be a number. Please try again.");
			stringInput = null;
			isIntInput = false;
		}

		if(!isIntInput) {
			stringInput = "";
			getIntInput();
		}
		return stringInput;
	}

	public static boolean stringIsNumber(String stringInput) {
		boolean isNumber = false;
		
		for(int i = 0; i < stringInput.length(); i++) {
			switch(stringInput.substring(i, i + 1)) {
			case "0": case "1": case "2": case "3": case "4": case "5": case "6": case "7": case "8": case "9":
				isNumber = true;
				break;
			default:
				return false;
			}
		}
		return isNumber;
	}
	
	public static String getStringInput() {	
		try {
			System.out.print("Input:     ");
			return consoleReader.readLine();
		} catch (IOException e) {
			System.out.println("Failed reading console input. (getStringInput())");
			e.printStackTrace();
		}
		return "";
	}

	public static void serializeBankUsers(Set<BankUser> userInfoSet) {
		
		try(FileOutputStream fos = new FileOutputStream(serializedUserInfoFile);
				ObjectOutputStream oos = new ObjectOutputStream(fos);){
			
			oos.writeObject(userInfoSet);
			
		} catch (FileNotFoundException e) {
			System.out.println("[Log] - Error while accessing the file.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[Log] - Error while writing to the file.");
			e.printStackTrace();
		}
	}

	public static Set<BankUser> getSerializedBankUsers (Set<BankUser> userInfoSet) {
		
		try {
			if(!serializedUserInfoFile.exists())
				serializedUserInfoFile.createNewFile();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
			
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serializedUserInfoFile));){

			userInfoSet = (Set<BankUser>) ois.readObject();
			
		} catch (FileNotFoundException e) {
			System.out.println("[Log] - Error while accessing the file.");
			e.printStackTrace();
		} catch (IOException e) {
//			System.out.println("[Log] - Error while reading the file.");				// I am still not sure why this is being thrown. The program runs regardless
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("[Log] - Error while deserializing the object.");
			e.printStackTrace();
		}
		
		return userInfoSet;
	}
}
