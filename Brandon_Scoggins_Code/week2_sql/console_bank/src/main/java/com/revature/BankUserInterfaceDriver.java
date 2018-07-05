package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
import com.revature.models.Transaction;
import com.revature.models.User;

public class BankUserInterfaceDriver {

	static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

	static UserDAO userDAO = new UserDAOImpl();
	static AccountsDAO accountsDAO = new AccountsDAOImpl();
	static CheckingAccountDAO checkingDAO = new CheckingDAOImpl();
	static SavingsAccountDAO savingsDAO = new SavingsDAOImpl();
	static TransactionDAO transactionDAO = new TransactionDAOImpl();

	static String input = "";

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

		if(activeUser.getFirstName().equals(" ")) {
			displayWelcome();
		}else{
			displayWelcome(activeUser.getFirstName());
		}

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
			userInformationMenu(activeUser, activeAccountId);
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
				System.out.println("The account holder may create one.\n");
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
		System.out.println("Account Id: 		");
		input = getIntInput();
		int intInput = Integer.parseInt(input);
		System.out.println();

		ArrayList<User> authorizedUsers = new ArrayList<>();
		authorizedUsers = accountsDAO.getAllAccountUsers(intInput);

		if(!authorizedUsers.isEmpty()) {
			for(User authorizedUser : authorizedUsers) {
				if(authorizedUser.getUserId() == activeUser.getUserId()) {
					System.out.println("Access granted!\n");
					accountAccessGranted = true;
					break;
				}
			}
		}

		if(accountAccessGranted) {
			displayLoggedInMenu(activeUser, intInput);
		} else {
			System.out.println("You are not authorized to that account.\n");
			displayLoggedInMenu(activeUser, activeAccountId);
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
			viewTransactionsByUserId(activeUser, activeAccountId, activeUser.getUserId());		
			break;									
		case "3":

			if(activeUser.getUserId() != accountsDAO.getAccountHolderId(activeAccountId)) {
				System.out.println("Only the account holder can view transactions by other users on their account.\n");
				transactionHistoryMenu(activeUser, activeAccountId);
			}else {
				System.out.println("Enter a user id.");
				int targetUserId = Integer.parseInt(getIntInput());
				System.out.println();
				ArrayList<User> existingUsers = new ArrayList<>();
				existingUsers = userDAO.getAllUsers();
				boolean userIdExist = false;

				for(User userThatExist : existingUsers) {
					if(targetUserId == userThatExist.getUserId()) {
						userIdExist = true;
						break;
					}
				}
				if(userIdExist) {
					viewTransactionsByUserId(activeUser, activeAccountId, targetUserId);
				}else {
					System.out.println("That user id does not exist.");
					transactionHistoryMenu(activeUser, activeAccountId);
				}
			}
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

	private static void viewTransactionsByUserId(User activeUser, int activeAccountId, int targetUserId) {

		ArrayList<Transaction> transactions = new ArrayList<>();
		ArrayList<User> users = new ArrayList<>();
		users = userDAO.getAllUsers();
		int accountHolderId = accountsDAO.getAccountHolderId(activeAccountId);
		User accountHolder = new User();

		if(activeUser.getUserId() == accountsDAO.getAccountHolderId(activeAccountId)) {

			transactions =  transactionDAO.getTransactionsByUserId(activeUser, targetUserId);

			for(Transaction trans : transactions) {
				System.out.println(trans.toString() + "\n");
			}

			transactionHistoryMenu(activeUser, activeAccountId);
		}else {
			for(User user : users)
			{
				if(user.getUserId() == accountHolderId) {
					accountHolder = user;
					break;
				}
			}

			transactions =  transactionDAO.getTransactionsByUserId(accountHolder, targetUserId);

			for(Transaction trans : transactions) {
				System.out.println(trans.toString() + "\n");
			}
			System.out.println();
			transactionHistoryMenu(activeUser, activeAccountId);
		}
	}

	private static void viewAllTransactions(User activeUser, int activeAccountId) {

		ArrayList<Transaction> transactions = new ArrayList<>();

		if(accountsDAO.getAccountHolderId(activeAccountId) != activeUser.getUserId()) {
			System.out.println("Only the account holder can view all transaction history.");
			transactionHistoryMenu(activeUser, activeAccountId);
		}else {
			transactions = transactionDAO.getAccountTransactions(activeUser);

			for(Transaction trans : transactions) {
				System.out.println(trans.toString() + "\n");
			}
			System.out.println();
			transactionHistoryMenu(activeUser, activeAccountId);
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

		if(input.equals("1") || input.equals("2") || input.equals("3")) {
			if(activeUser.getUserId() != accountsDAO.getAccountHolderId(activeAccountId)) {
				System.out.println("Only the account holder may access this field.");
				accountAccessMenu(activeUser, activeAccountId);
			}else {
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
				default:
					System.out.println("Un-anticipated error in displayLoggedInMenu()");
					System.exit(0);				
				}
			}
		}else {
			switch(input) {
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
	}

	private static void deauthorizeUser(User activeUser, int activeAccountId) {

		System.out.println("Enter a user id to deauthorize.");
		int targetUserId = Integer.parseInt(getIntInput());
		System.out.println();
		ArrayList<User> authorizedUsers = new ArrayList<>();
		authorizedUsers = accountsDAO.getAllAccountUsers(activeUser);
		boolean userIsAuthorized = false;

		for(User userThatIsAuthorized : authorizedUsers) {
			if(targetUserId == userThatIsAuthorized.getUserId()) {
				userIsAuthorized = true;
				break;
			}
		}
		if(userIsAuthorized) {
			if(accountsDAO.deAuthorizeUser(activeUser, targetUserId))
				System.out.println("User " + targetUserId + " has been deauthorized from this account.\n");
			accountAccessMenu(activeUser, activeAccountId);
		}else {
			System.out.println("That user is not authorized on this account.\n");
			accountAccessMenu(activeUser, activeAccountId);
		}
	}

	private static void authorizeUser(User activeUser, int activeAccountId) {

		System.out.println("Enter a user id to authorize.");
		int targetUserId = Integer.parseInt(getIntInput());
		System.out.println();
		ArrayList<User> authorizedUsers = new ArrayList<>();
		authorizedUsers = accountsDAO.getAllAccountUsers(activeUser);
		boolean userIsAuthorized = false;

		for(User userThatIsAuthorized : authorizedUsers) {
			if(targetUserId == userThatIsAuthorized.getUserId()) {
				userIsAuthorized = true;
				break;
			}
		}

		ArrayList<User> usersThatExist = new ArrayList<>();

		usersThatExist = userDAO.getAllUsers();

		boolean userIdExist = false;

		for (User existingUser : usersThatExist) {
			if(existingUser.getUserId() == targetUserId) {
				userIdExist = true;
			}
		}

		if(!userIsAuthorized && userIdExist) {
			accountsDAO.authorizeUser(activeUser, targetUserId);
			System.out.println("User " + targetUserId + " has been authorized to this account.\n");
			accountAccessMenu(activeUser, activeAccountId);
		}else if(!userIsAuthorized && !userIdExist){
			System.out.println("That user id was not found.\n");
			accountAccessMenu(activeUser, activeAccountId);
		}else {
			System.out.println("That user is already authorized on this account.\n");
			accountAccessMenu(activeUser, activeAccountId);
		}
	}

	private static void viewAuthorizedUsers(User activeUser, int activeAccountId) {

		ArrayList<User> authorizedUsers = new ArrayList<>();
		authorizedUsers = accountsDAO.getAllAccountUsers(activeUser);
		System.out.println("Displaying users authorized to account: " + activeAccountId + "\n");
		for(User userThatIsAuthorized : authorizedUsers) {
			System.out.println(userThatIsAuthorized.toString() + "\n");
		}
		System.out.println();
		accountAccessMenu(activeUser, activeAccountId);
	}

	public static void userInformationMenu(User activeUser, int activeAccountId) {

		String input = null;

		System.out.println("---------------------------------");
		System.out.println("|     User Information Menu     |");
		System.out.println("---------------------------------");
		System.out.println("| Would you like to..           |");
		System.out.println("| [1] - View User & Account Id  |");
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

		switch(input) {				
		case "1":
			viewUserId(activeUser, activeAccountId);
			break;
		case "2":
			updateFirstName(activeUser, activeAccountId);
			break;
		case "3":
			updateLastName(activeUser, activeAccountId);
			break;
		case "4":
			updateUserName(activeUser, activeAccountId);
			break;
		case "5":
			updatePassWord(activeUser, activeAccountId);
			break;
		case "6":
			updateEmail(activeUser, activeAccountId);
			break;
		case "7":
			displayLoggedInMenu(activeUser, activeAccountId);
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

	private static void updateEmail(User activeUser, int activeAccountId) {

		System.out.println("Enter your new email.");
		String input = getStringInput();
		boolean emailAvailable = true;

		System.out.println("Confirm your new email.");
		if(!input.equals(getStringInput())) {
			System.out.println("\nEntries did not match.\n");
			userInformationMenu(activeUser, activeAccountId);
		}else {
			ArrayList<User> users = new ArrayList<>();
			users = userDAO.getAllUsers();

			for(User user : users) {
				if(user.getEmail().equals(input)) {
					System.out.println("That email is already taken.");
					emailAvailable = false;
					break;
				}
			}
			if(emailAvailable) {
				activeUser.setEmail(input);
				userDAO.updateUser(activeUser);
				userInformationMenu(activeUser, activeAccountId);
			}else {
				userInformationMenu(activeUser, activeAccountId);
			}
		}
	}

	private static void updatePassWord(User activeUser, int activeAccountId) {

		System.out.println("Enter your new password.");
		String input = getStringInput();

		System.out.println("Confirm your new password.");
		if(!input.equals(getStringInput())) {
			System.out.println("\nEntries did not match.\n");
			userInformationMenu(activeUser, activeAccountId);
		}else {
			activeUser.setPassWord(input);
			userDAO.updateUser(activeUser);
			userInformationMenu(activeUser, activeAccountId);
		}
	}

	private static void updateUserName(User activeUser, int activeAccountId) {

		System.out.println("Enter your new username.");
		String input = getStringInput();
		boolean userNameAvailable = true;

		System.out.println("Confirm your new username.");
		if(!input.equals(getStringInput())) {
			System.out.println("\nEntries did not match.\n");
			userInformationMenu(activeUser, activeAccountId);
		}else {
			ArrayList<User> users = new ArrayList<>();
			users = userDAO.getAllUsers();

			for(User user : users) {
				if(user.getUserName().equals(input)) {
					System.out.println("That username is already taken.");
					userNameAvailable = false;
					break;
				}
			}
			if(userNameAvailable) {
				activeUser.setUserName(input);
				userDAO.updateUser(activeUser);
				userInformationMenu(activeUser, activeAccountId);
			}else {
				userInformationMenu(activeUser, activeAccountId);
			}
		}
	}

	private static void updateLastName(User activeUser, int activeAccountId) {

		System.out.println("Enter your new last name.");
		String input = getStringInput();

		System.out.println("Confirm your new last name.");
		if(!input.equals(getStringInput())) {
			System.out.println("\nEntries did not match.\n");
			userInformationMenu(activeUser, activeAccountId);
		}else {
			activeUser.setLastName(input);
			userDAO.updateUser(activeUser);
			userInformationMenu(activeUser, activeAccountId);
		}
	}

	private static void updateFirstName(User activeUser, int activeAccountId) {

		System.out.println("Enter your new first name.");
		String input = getStringInput();

		System.out.println("Confirm your new first name.");
		if(!input.equals(getStringInput())) {
			System.out.println("\nEntries did not match.\n");
			userInformationMenu(activeUser, activeAccountId);
		}else {
			activeUser.setFirstName(input);
			userDAO.updateUser(activeUser);
			userInformationMenu(activeUser, activeAccountId);
		}
	}

	private static void viewUserId(User activeUser, int activeAccountId) {

		System.out.println("Your user id is: " + userDAO.getUserId(activeUser));
		System.out.println("Your account id is: " + accountsDAO.getAccountIdByUser(activeUser));
		System.out.println();
		userInformationMenu(activeUser, activeAccountId);
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
		System.out.println("Account Id: 		");
		targetAccountId = getIntInput();
		int intInput = Integer.parseInt(targetAccountId);

		System.out.println("\nWhich account type ['1' for checking | '2' for savings] do you want to transfer funds to?");
		System.out.println("Account Type: 		");

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
			System.out.println("That account does not exist.\n");
			checkingAccountMenu(activeUser, activeAccountId);
		}else if(!targetAccountTypeExist){
			System.out.println("Target account type does not exist.\n");
			checkingAccountMenu(activeUser, activeAccountId);
		}else {

			System.out.println("Transfer Amount: ");

			double transferAmount = getCashInput();

			if(transferAmount > checkingDAO.getCheckingBalanceByAccountId(activeAccountId)) {
				System.out.println("\nCannot transfer more money than is in the account.\n");
				checkingAccountMenu(activeUser, activeAccountId);
			}else {
				checkingDAO.withdrawChecking(activeUser, activeAccountId, transferAmount);

				if(targetAccountType.equals("Checking")) {
					checkingDAO.depositChecking(activeUser, intInput, transferAmount);
					transactionDAO.recordTransaction(activeUser, activeAccountId, "Checking", intInput, targetAccountType, transferAmount);
				}else {
					savingsDAO.depositSavings(activeUser, intInput, transferAmount);
					transactionDAO.recordTransaction(activeUser, activeAccountId, "Checking", intInput, targetAccountType, transferAmount);
				}

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
		System.out.println("Account Id: 		");
		targetAccountId = getIntInput();
		int intInput = Integer.parseInt(targetAccountId);

		System.out.println("\nWhich account type ['1' for checking | '2' for savings] do you want to transfer funds to?");
		System.out.println("Account Type: 		");

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
			System.out.println("That account does not exist.\n");
			savingsAccountMenu(activeUser, activeAccountId);
		}else if(!targetAccountTypeExist){
			System.out.println("Target account type does not exist.\n");
			savingsAccountMenu(activeUser, activeAccountId);
		}else {

			System.out.print("Transfer Amount: ");

			double transferAmount = getCashInput();

			if(transferAmount > savingsDAO.getSavingsBalanceByAccountId(activeAccountId)) {
				System.out.println("\nCannot transfer more money than is in the account.\n");
				savingsAccountMenu(activeUser, activeAccountId);
			}else {
				savingsDAO.withdrawSavings(activeUser, activeAccountId, transferAmount);

				if(targetAccountType.equals("Checking")) {
					checkingDAO.depositChecking(activeUser, intInput, transferAmount);
					transactionDAO.recordTransaction(activeUser, activeAccountId, "Savings", intInput, targetAccountType, transferAmount);
				}else {
					savingsDAO.depositSavings(activeUser, intInput, transferAmount);
					transactionDAO.recordTransaction(activeUser, activeAccountId, "Savings", intInput, targetAccountType, transferAmount);
				}

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

		User newUser = new User(1, " ", " ", userName, passWord, email);
		userDAO.createUser(newUser);

		User accountHolder = userDAO.logInUser(userName, passWord);

		accountsDAO.authorizeUser(accountHolder, accountHolder.getUserId());

		System.out.println("\nRegistration Successful!");
		System.out.println("Please update your user information at your convenience.\n");

		System.out.println();		
		displayUnLoggedInMenu();
	}

	public static void logInUser() {

		System.out.println("To login, please enter a username/email and password\n");

		System.out.println("Username/email: ");
		String userNameOrEmail = getStringInput();
		System.out.println("Password: ");
		String passWord = getStringInput();

		User activeUser = new User();

		activeUser = userDAO.logInUser(userNameOrEmail, passWord);

		if (activeUser.equals(new User())) {
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
		input = getStringInput();
		char[] charInputArray = input.toCharArray();
		if(charInputArray.length == 0) {
			System.out.println("\nNo input was entered. Try again.");
			getCashInput();
		}else if(charInputArray.length < 3) {	
			System.out.println("\nInput too short. Please try again.");
			getCashInput();
		}else if(charInputArray.length > 10) {	
			System.out.println("\nInput too long. Please try again.");
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
		input = getStringInput();
		boolean isIntInput = true;
		if(input.length() == 0) {
			System.out.println("\nNo input was entered. Try again.");
			input = null;
			isIntInput = false;
		}else if(input.length() > 1) {
			System.out.println("\nInput too long. Please try again.");
			input = null;
			isIntInput = false;
		}else if(!stringIsNumber(input)) {
			System.out.println("\nInput must be a number. Please try again.");
			input = null;
			isIntInput = false;
		}
		if(!isIntInput) {
			input = "";
			getMenuInput();
		}
		return input;
	}

	public static String getIntInput() {
		input = getStringInput();
		boolean isIntInput = true;
		if(input.length() == 0) {
			System.out.println("\nNo input was entered. Try again.");
			input = null;
			isIntInput = false;
		}else if(input.length() > 10) {
			System.out.println("\nInput too long. Please try again.");
			input = null;
			isIntInput = false;
		}else if(!stringIsNumber(input)) {
			System.out.println("\nInput must be a number. Please try again.");
			input = null;
			isIntInput = false;
		}
		if(!isIntInput) {
			input = "";
			getIntInput();
		}
		return input;
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
}
