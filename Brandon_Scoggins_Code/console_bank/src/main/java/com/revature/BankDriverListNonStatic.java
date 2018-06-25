package com.revature;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/*
 * Copy of ArrayList approach but moved static variables into the main method and update each method to
 * take parameters that were the static variables
 */


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

public class BankDriverListNonStatic {

	public static void main(String[] args) {

		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		String input = "";

		File userInfoFile = new File("C:\\batch-repos\\1806-Jun18-Java-USF\\Brandon_Scoggins_Code\\console_bank\\src\\main\\resources\\Bank_Users");

		List<String[]> userInfoList = new ArrayList<>();
		String userName = new String("username");
		String passWord = new String("password");
		String balance = new String("balance");
		String[] userDetails = new String[3];

		populateUserInfoMap(userInfoFile, userName, passWord, balance, userDetails, userInfoList);

		displayUnLoggedInMenu(userName, passWord, balance, userDetails, input, userInfoList, userInfoFile, consoleReader);
	}

	public static void displayWelcome() {

		System.out.println("Welcome to Console Bank");
	}

	public static void displayWelcome(String name) {

		System.out.println("Welcome, " + name + ", to Console Bank");
	}

	public static void displayUnLoggedInMenu(String userName, String passWord, String balance, String[] userDetails, String input, List<String[]> userInfoList, File userInfoFile, BufferedReader consoleReader) {

		displayWelcome();
		userName = new String("username");
		passWord = new String("password");
		balance = new String("balance");
		userDetails[0] = new String("username1");
		userDetails[1] = new String("password1");
		userDetails[2] = new String("balance1");
		
		System.out.println("---------------------------");
		System.out.println("| [1] - Log In            |");
		System.out.println("| [2] - Register New User |");
		System.out.println("| [3] - Quit              |");
		System.out.println("---------------------------");
		do {
			input = ("" + getIntInput(input, consoleReader));			// 'cast' to static String input to avoid creating additional variables
			if(!input.equals("1") && !input.equals("2") && !input.equals("3"))
				System.out.println("Please enter a valid menu option.");
		}while(!input.equals("1") && !input.equals("2") && !input.equals("3"));

		System.out.println();

		switch(input) {
		case "1":
			logInUser(userName, passWord, balance, userDetails, input, userInfoList, userInfoFile, consoleReader);
			break;
		case "2":
			registerNewUser(userName, passWord, balance, userDetails, input, userInfoList, userInfoFile, consoleReader);
			break;
		case "3":
			writeUserInfoMap(userInfoFile, userInfoList);
			break;
		default:
			System.out.println("Un-anticipated error in displayUnLoggedInMenu()");
			System.exit(0);					// verify argument for System.exit()
		}
	}

	public static void displayLoggedInMenu(String userName, String passWord, String balance, String[] userDetails, String input, List<String[]> userInfoList, File userInfoFile, BufferedReader consoleReader) {
		
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
			input = ("" + getIntInput(input, consoleReader));			
			if(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5"))
				System.out.println("Please enter a valid menu option.");
		}while(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5"));

		System.out.println();

		switch(input) {
		case "1":
			checkBalance(userName, passWord, balance, userDetails, input, userInfoList, userInfoFile, consoleReader);
			break;
		case "2":
			withdraw(userName, passWord, balance, userDetails, input, userInfoList, userInfoFile, consoleReader);
			break;
		case "3":
			deposit(userName, passWord, balance, userDetails, input, userInfoList, userInfoFile, consoleReader);
			break;
		case "4":
			logOutUser(userName, passWord, balance, userDetails, input, userInfoList, userInfoFile, consoleReader);
			break;
		case "5":
			writeUserInfoMap(userInfoFile, userInfoList);
			break;
		default:
			System.out.println("Un-anticipated error in displayLoggedInMenu()");
			System.exit(0);					// verify argument for System.exit()
		}
	}
	
	public static void checkBalance(String userName, String passWord, String balance, String[] userDetails, String input, List<String[]> userInfoList, File userInfoFile, BufferedReader consoleReader) {
		
		System.out.println();
		System.out.println("Current Balance: $" + balance);
		System.out.println();
		
		displayLoggedInMenu(userName, passWord, balance, userDetails, input, userInfoList, userInfoFile, consoleReader);
	}
	
	public static void withdraw(String userName, String passWord, String balance, String[] userDetails, String input, List<String[]> userInfoList, File userInfoFile, BufferedReader consoleReader) {		// prevent overdrafts?
		
		System.out.println();
		System.out.println("Withdraw Amount: ");
		balance = ("" + (Double.parseDouble(balance) - getCashInput(input, consoleReader)));
		
		checkBalance(userName, passWord, balance, userDetails, input, userInfoList, userInfoFile, consoleReader);
	}
	
	public static void deposit(String userName, String passWord, String balance, String[] userDetails, String input, List<String[]> userInfoList, File userInfoFile, BufferedReader consoleReader) {
		
		System.out.println();
		System.out.println("Deposit Amount: ");
		balance = ("" + (Double.parseDouble(balance) + getCashInput(input, consoleReader)));
		
		checkBalance(userName, passWord, balance, userDetails, input, userInfoList, userInfoFile, consoleReader);
	}
	
	public static void logOutUser(String userName, String passWord, String balance, String[] userDetails, String input, List<String[]> userInfoList, File userInfoFile, BufferedReader consoleReader) {
		System.out.println();
		System.out.println("Log Out Successful");
		System.out.println();
		
		//should be unnecessary to update map at this point, but will do so just in case
		for(String[] user : userInfoList) {
			if (user[0].equals(userName)){
				user[2] = balance;
				break;
			}
		}
		
		displayUnLoggedInMenu(userName, passWord, balance, userDetails, input, userInfoList, userInfoFile, consoleReader);
	}

	public static void registerNewUser(String userName, String passWord, String balance, String[] userDetails, String input, List<String[]> userInfoList, File userInfoFile, BufferedReader consoleReader) {

		boolean isUnique;
		
		System.out.println("To register a new user, please enter a username and password\n");
		do {
			System.out.println("Username: ");
			userName = getStringInput(consoleReader);
			
			isUnique = true;
			
			for(String[] user : userInfoList) {
				if (user[0].equals(userName)) {
					System.out.println("That username already exist. Please try again.");	 		// could add option to quit registering if username exist	
					isUnique = false;
					break;
				}
			}
		}while(!isUnique);

		do {
			System.out.println("Password: ");
			passWord = getStringInput(consoleReader);
			System.out.println("Confirm Password: ");
			if (!passWord.equals(getStringInput(consoleReader)))
				System.out.println("Passwords do not match. Try again.");
			else
				break;
		}while(true);

		System.out.println();

		System.out.println("Registration Successful!");
		balance = "0.00";
		userDetails[0] = userName;
		userDetails[1] = passWord;
		userDetails[2] = balance;
		userInfoList.add(userDetails);
		System.out.println("details: " + userInfoList.get(0)[0] + " " + userInfoList.get(0)[1] + " " + userInfoList.get(0)[2]);
		System.out.println();		

//		System.out.println(userName + " " + userInfoMap.get(userName)[0] + " " + userInfoMap.get(userName)[1]);
////////////////////////////////////////////////////
//		for(Map.Entry<String, String[]> entry : userInfoMap.entrySet()) {
//			System.out.println("Key: " + entry.getKey() + ", Password: " + entry.getValue()[0] + ", Balance: " + entry.getValue()[1]);
//		}
////////////////////////////////////////////////////
		displayUnLoggedInMenu(userName, passWord, balance, userDetails, input, userInfoList, userInfoFile, consoleReader);
	}

	public static void logInUser(String userName, String passWord, String balance, String[] userDetails, String input, List<String[]> userInfoList, File userInfoFile, BufferedReader consoleReader) {

		System.out.println("To login, please enter a username and password\n");

		System.out.println("Username: ");
		userName = getStringInput(consoleReader);
		System.out.println("Password: ");
		passWord = getStringInput(consoleReader);
		
		boolean credentialsCorrect = false;
		
		for (String[] user : userInfoList) {
			System.out.println("searching database");
			System.out.println("details: " + userInfoList.get(0)[0] + " " + userInfoList.get(0)[1] + " " + userInfoList.get(0)[2]);
			if (user[0] == (userName)) {
				System.out.println("user name matched");
				if (user[1].equals(passWord)){
					System.out.println("password matched");
					credentialsCorrect = true;
					break;
				}
			}
		}
		
		if (!credentialsCorrect) {
			System.out.println("That information is not in our database.");
			displayUnLoggedInMenu(userName, passWord, balance, userDetails, input, userInfoList, userInfoFile, consoleReader);
		}

		System.out.println();
		System.out.println("Login Successful!");
		System.out.println();

		for(String[] user : userInfoList) {
			if (user[0].equals(userName)) {
				balance = user[2];
				break;
			}
		}
		
		displayLoggedInMenu(userName, passWord, balance, userDetails, input, userInfoList, userInfoFile, consoleReader);
	}
	
	public static double getCashInput(String input, BufferedReader consoleReader) {
		
		System.out.println();
		System.out.println("Enter a cash value (##.##)");
		input = getStringInput(consoleReader);
		char[] charInputArray = input.toCharArray();
		if(charInputArray.length == 0) {
			System.out.println("No input was entered. Try again.");
			getCashInput(input, consoleReader);
		}else if(charInputArray.length < 3) {	
			System.out.println("Input too short. Please try again.");
			getCashInput(input, consoleReader);
		}else if(charInputArray[charInputArray.length - 3] != '.') {		// check that third from last character is a decimal
			System.out.println("Incorrect format. Please try again.");
			getCashInput(input, consoleReader);
		}
		return Double.parseDouble(input);
	}

	public static int getIntInput(String input, BufferedReader consoleReader) {
		// get string input, cast to char[], check if every character is a number, then cast to Integer
		input = getStringInput(consoleReader);
		char[] charInputArray = input.toCharArray();
		if(charInputArray.length == 0) {
			System.out.println("No input was entered. Try again.");
			getIntInput(input, consoleReader);
		}else if(charInputArray.length > 1) {
			System.out.println("Input too long. Please try again.");
			getIntInput(input, consoleReader);
		}else if(!charIsNumber(charInputArray[0])) {
			System.out.println("Input must be a number. Please try again.");
			getIntInput(input, consoleReader);
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

	public static String getStringInput(BufferedReader consoleReader) {		// use separate method for getting input to reduce try/catch statements
		try {
			System.out.print("Input: ");
			return consoleReader.readLine();
		} catch (IOException e) {
			System.out.println("Failed reading console input. (getStringInput())");
			e.printStackTrace();
		}
		return "";
	}

	public static void populateUserInfoMap(File userInfoFile, String userName, String passWord, String balance, String[] userDetails, List<String[]> userInfoList) {


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
					userDetails[0] = userName;
					break;
				case 2:
					passWord = line;
					userDetails[1] = passWord;
					break;
				case 3:
					balance = line;
					userDetails[2] = balance;

					userInfoList.add(userDetails);

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

	public static void writeUserInfoMap(File userInfoFile, List<String[]> userInfoList) {

		System.out.println("Thanks for using Console Bank!");
		
		BufferedWriter fileWriter = null;
		try {
			fileWriter = new BufferedWriter(new FileWriter(userInfoFile));

			for(String[] user : userInfoList) {
				fileWriter.write(user[0] + "\n" + user[1] + "\n" + user[2] + "\n");
			}
			
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
