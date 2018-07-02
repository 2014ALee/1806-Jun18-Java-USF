package com.revature;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * using whole numbers for now. Add functionality for change in money amounts
 *  - maybe ask for dollar and change amounts separately
 *  
 *  - make a method getDollarAmount() that is similar to getIntInput()
 */

/*
 * getIntInput may be unnecessary but already programmed it.. May remove later if time allows
 */

/*
 * open file when program is ran, read usernames, passwords and balances into a map (balances as a string?)
 * update the map with deposits/withdrawals and new users
 * then write map data to the file at the close of the program
 */

/*
 * already check to create new file and replace at end of program. For now, those are commented out and an extra
 * line is erasing the new file
 */

/*
 *  double formatting to end with .##
 *  
 *  format printing to console
 *  
 *  figure out how maps work
 */

/*
 * issue with map. It looks like its pass by reference..
 */

public class BankDriver {

	static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
	static String input = "";

	static File userInfoFile = new File("C:\\batch-repos\\1806-Jun18-Java-USF\\Brandon_Scoggins_Code\\console_bank\\src\\main\\resources\\Bank_Users");

	static Map<String, String[]> userInfoMap = new HashMap<String, String[]>();
	static String userName, passWord, balance;
	static String[] userDetails = new String[2];

	public static void main(String[] args) {

		populateUserInfoMap();

		displayUnLoggedInMenu();
	}

	public static void displayWelcome() {

		System.out.println("Welcome to Console Bank");
	}

	public static void displayWelcome(String name) {

		System.out.println("Welcome, " + name + ", to Console Bank");
	}

	public static void displayUnLoggedInMenu() {

		displayWelcome();
		userName = "";
		passWord = "";
		balance = "";
		userDetails[0] = "";
		userDetails[1] = "";
		
		System.out.println("---------------------------");
		System.out.println("| [1] - Log In            |");
		System.out.println("| [2] - Register New User |");
		System.out.println("| [3] - Quit              |");
		System.out.println("---------------------------");
		do {
			input = ("" + getIntInput());			// 'cast' to static String input to avoid creating additional variables
			if(!input.equals("1") && !input.equals("2") && !input.equals("3"))
				System.out.println("Please enter a valid menu option.");
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
			writeUserInfoMap();
			break;
		default:
			System.out.println("Un-anticipated error in displayUnLoggedInMenu()");
			System.exit(0);					// verify argument for System.exit()
		}
	}

	public static void displayLoggedInMenu() {
		
		displayWelcome(userName);
		// withdrawl, deposit, check balance, log out
		System.out.println("---------------------------");
		System.out.println("| [1] - Check Balance     |");
		System.out.println("| [2] - Withdraw          |");
		System.out.println("| [3] - Deposit           |");
		System.out.println("| [4] - Log Out           |");
		System.out.println("| [5] - Quit              |");
		System.out.println("---------------------------");
		do {
			input = ("" + getIntInput());			
			if(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5"))
				System.out.println("Please enter a valid menu option.");
		}while(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5"));

		System.out.println();

		switch(input) {
		case "1":
			checkBalance();
			break;
		case "2":
			withdraw();
			break;
		case "3":
			deposit();
			break;
		case "4":
			logOutUser();
			break;
		case "5":
			writeUserInfoMap();
			break;
		default:
			System.out.println("Un-anticipated error in displayLoggedInMenu()");
			System.exit(0);					// verify argument for System.exit()
		}
	}
	
	public static void checkBalance() {
		
		System.out.println();
		System.out.println("Current Balance: $" + userInfoMap.get(userName)[1]);
		System.out.println();
		
		displayLoggedInMenu();
	}
	
	public static void withdraw() {		// prevent overdrafts?
		
		System.out.println();
		System.out.println("Withdraw Amount: ");
		userDetails[1] = ("" + (Double.parseDouble(userInfoMap.get(userName)[1]) - getCashInput()));
		
		userInfoMap.put(userName, userDetails);
		
		checkBalance();
	}
	
	public static void deposit() {
		
		System.out.println();
		System.out.println("Deposit Amount: ");
		userDetails[1] = ("" + (Double.parseDouble(userInfoMap.get(userName)[1]) + getCashInput()));
		
		userInfoMap.put(userName, userDetails);
		
		checkBalance();
	}
	
	public static void logOutUser() {
		System.out.println();
		System.out.println("Log Out Successful");
		System.out.println();
		
		//should be unnecessary to update map at this point, but will do so just in case
		userInfoMap.put(userName, userDetails);
		
		displayUnLoggedInMenu();
	}

	public static void registerNewUser() {

		System.out.println("To register a new user, please enter a username and password\n");
		do {
			System.out.println("Username: ");
			userName = getStringInput();
			if (userInfoMap.containsKey(userName)) 
				System.out.println("That username already exist. Please try again.");	 		// could add option to quit registering if username exist
			else
				break;
		}while(true);

		do {
			System.out.println("Password: ");
			passWord = getStringInput();
			System.out.println("Confirm Password: ");
			if (!passWord.equals(getStringInput()))
				System.out.println("Passwords do not match. Try again.");
			else
				break;
		}while(true);

		System.out.println();

		System.out.println("Registration Successful!");
		balance = "0.00";
		userDetails = new String[2];
		userDetails[0] = passWord;
		userDetails[1] = balance;
		userInfoMap.put(userName, userDetails);

		System.out.println(userName + " " + userInfoMap.get(userName)[0] + " " + userInfoMap.get(userName)[1]);
////////////////////////////////////////////////////
		for(Map.Entry<String, String[]> entry : userInfoMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Password: " + entry.getValue()[0] + ", Balance: " + entry.getValue()[1]);
		}
////////////////////////////////////////////////////
		displayUnLoggedInMenu();
	}

	public static void logInUser() {

		System.out.println("To login, please enter a username and password\n");

		System.out.println("Username: ");
		userName = getStringInput();
		System.out.println("Password: ");
		passWord = getStringInput();
		if (!userInfoMap.containsKey(userName) || !userInfoMap.get(userName)[0].equals(passWord)) {			// broke up into two if statements to avoid NullPointerException
			System.out.println("That information is not in our database.");
			displayUnLoggedInMenu();
		}
		
//		if(userInfoMap.containsKey(userName)) {
//			if(!userInfoMap.get(userName)[0].equals(passWord)) {
//				System.out.println("That information is not in our database.");
//				displayUnLoggedInMenu();
//			}
//		}else {
//			System.out.println("That information is not in our database.");
//			displayUnLoggedInMenu();
//		}
		
//		if(!userInfoMap.containsKey(userName)) {
//			System.out.println("That information is not in our database.");
//			displayUnLoggedInMenu();
//		}else if(!userInfoMap.get(userName)[0].equals(passWord)) {
//			System.out.println("That information is not in our database.");
//			displayUnLoggedInMenu();
//		}

		System.out.println();
		System.out.println("Login Successful!");
		System.out.println();

		userDetails[1] = userInfoMap.get(userName)[1];
		
		displayLoggedInMenu();
	}
	
	public static double getCashInput() {
		
		System.out.println();
		System.out.println("Enter a cash value (##.##)");
		input = getStringInput();
		char[] charInputArray = input.toCharArray();
		if(charInputArray.length == 0) {
			System.out.println("No input was entered. Try again.");
			getCashInput();
		}else if(charInputArray.length < 3) {	
			System.out.println("Input too short. Please try again.");
			getCashInput();
		}else if(charInputArray[charInputArray.length - 3] != '.') {		// check that third from last character is a decimal
			System.out.println("Incorrect format. Please try again.");
			getCashInput();
		}
		return Double.parseDouble(input);
	}

	public static int getIntInput() {
		// get string input, cast to char[], check if every character is a number, then cast to Integer
		input = getStringInput();
		char[] charInputArray = input.toCharArray();
		if(charInputArray.length == 0) {
			System.out.println("No input was entered. Try again.");
			getIntInput();
		}else if(charInputArray.length > 1) {
			System.out.println("Input too long. Please try again.");
			getIntInput();
		}else if(!charIsNumber(charInputArray[0])) {
			System.out.println("Input must be a number. Please try again.");
			getIntInput();
		}
		return Integer.parseInt(input);
//		for (char character : charInputArray) {				// for loop acts weirdly when in this loop. Seems to continue with previous char[] although its called with a new char[]
//			if(!charIsNumber(character)) {
//				System.out.println("Input must be a number. Please try again.");
//				getIntInput();
//			}
//		}
	}

	public static boolean charIsNumber(char character) {
		switch(character) {
		case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
			return true;
		default:
			return false;
		}
	}

	public static String getStringInput() {		// use separate method for getting input to reduce try/catch statements
		try {
			System.out.print("Input: ");
			return consoleReader.readLine();
		} catch (IOException e) {
			System.out.println("Failed reading console input. (getStringInput())");
			e.printStackTrace();
		}
		return "";
	}

	public static void populateUserInfoMap() {


		// does the writer need to be closed before the reader can be created?
		BufferedReader fileReader = null;
		try {
			if(!userInfoFile.exists())
				userInfoFile.createNewFile();

			fileReader = new BufferedReader(new FileReader(userInfoFile));

			String line = fileReader.readLine();
			// rather than use a delimiter, store one parameter per line in a specific sequence
			int counter = 1;
			while(line != null) {

				//				userInfoMap.put(fileReader.readLine(), {fileReader.readLine(), fileReader.readLine()})		// why does this not work?
				switch(counter) {
				case 1:
					userName = line;
					break;
				case 2:
					passWord = line;
					userDetails[0] = passWord;
					break;
				case 3:
					balance = line;
					userDetails[1] = balance;

					userInfoMap.put(userName, userDetails);

					counter = 0;
					break;
				default:
					break;
				}

				line = fileReader.readLine();
				counter++;
			}

		} catch (IOException e) {							
			e.printStackTrace();
		}finally {
			if(fileReader != null)
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public static void writeUserInfoMap() {

		System.out.println("Thanks for using Console Bank!");
		
		BufferedWriter fileWriter = null;
		try {
			fileWriter = new BufferedWriter(new FileWriter(userInfoFile));

			for(Map.Entry<String, String[]> entry : userInfoMap.entrySet())
				fileWriter.write(entry.getKey() + "\n" + entry.getValue()[0] + "\n" + entry.getValue()[1] + "\n");	 	// this leaves a blank line at the end of the file that will cause the populate method to read an additional username. This shouldnt be a problem(potentially compounding lines) since the file is written new each time, and only users with passwords and balances are written

		} catch (IOException e) {							
			e.printStackTrace();
		}finally {
			if(fileWriter != null)
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		System.exit(0);
	}
}
