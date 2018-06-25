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
 * forget collections. Check all input against the file
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

public class BankDriverFileReferenced {

	static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
	static String input = "";

	static File userInfoFile = new File("C:\\batch-repos\\1806-Jun18-Java-USF\\Brandon_Scoggins_Code\\console_bank\\src\\main\\resources\\Bank_Users");
	static String filePath = "C:\\batch-repos\\1806-Jun18-Java-USF\\Brandon_Scoggins_Code\\console_bank\\src\\main\\resources\\Bank_Users";

	static String userName, passWord, balance;

	public static void main(String[] args) {

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
			System.out.println("Thanks for using Console Bank!");
			updateUserInfoFile();
			System.exit(0);
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
			System.out.println("Thanks for using Console Bank!");
			updateUserInfoFile();
			System.exit(0);
			break;
		default:
			System.out.println("Un-anticipated error in displayLoggedInMenu()");
			System.exit(0);					// verify argument for System.exit()
		}
	}
	
	public static void checkBalance() {
		
		System.out.println();
		System.out.println("Current Balance: $" + balance);
		System.out.println();
		
		displayLoggedInMenu();
	}
	
	public static void withdraw() {		// prevent overdrafts?
		
		System.out.println();
		System.out.println("Withdraw Amount: ");
		balance = ("" + (Double.parseDouble(balance) - getCashInput()));
		
		checkBalance();
	}
	
	public static void deposit() {
		
		System.out.println();
		System.out.println("Deposit Amount: ");
		balance = ("" + (Double.parseDouble(balance) + getCashInput()));
		
		checkBalance();
	}
	
	public static void logOutUser() {
		System.out.println();
		System.out.println("Log Out Successful");
		System.out.println();
		
		updateUserInfoFile();
		
		displayUnLoggedInMenu();
	}

	public static void registerNewUser() {

		System.out.println("To register a new user, please enter a username and password\n");
		do {
			System.out.println("Username: ");
			userName = getStringInput();
			if (userNameExist()) 
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
		
		updateUserInfoFile();
		
		displayUnLoggedInMenu();
	}

	public static void logInUser() {

		System.out.println("To login, please enter a username and password\n");

		System.out.println("Username: ");
		userName = getStringInput();
		System.out.println("Password: ");
		passWord = getStringInput();
		if (!userNameExist() || !passWordMatches()) {			
			System.out.println("That information is not in our database.");
			displayUnLoggedInMenu();
		}

		System.out.println();
		System.out.println("Login Successful!");
		System.out.println();
		
		updateBalance();
		
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
	
	public static boolean userNameExist() {

		BufferedReader fileReader = null;
		try {
			if(!userInfoFile.exists())
				userInfoFile.createNewFile();

			fileReader = new BufferedReader(new FileReader(userInfoFile));

			String line = fileReader.readLine();
			// rather than use a delimiter, store one parameter per line in a specific sequence
			int counter = 1;
			while(line != null) {	
				
				if(counter % 3 == 1 && userName.equals(line)) {
					return true;
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
		
		return false;
	}
	
	public static boolean passWordMatches() {
		
		BufferedReader fileReader = null;
		try {
			if(!userInfoFile.exists())
				userInfoFile.createNewFile();

			fileReader = new BufferedReader(new FileReader(filePath));

			String line = fileReader.readLine();
			System.out.println(line + ": this was read in passWordMatches()");
			// rather than use a delimiter, store one parameter per line in a specific sequence
			int counter = 1;
			while(line != null) {	
				
				if(counter % 3 == 1 && userName.equals(line)) {
					break;
				}
				
				line = fileReader.readLine();
				counter++;
			}
			
			line = fileReader.readLine();
			if(passWord.equals(line)) {
				return true;
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
		
		return false;
	}

	public static void updateUserInfoFile() {


		List<String> userInfoList = null;
		userInfoList = new ArrayList<>();
		
		BufferedReader fileReader = null;
		BufferedWriter fileWriter = null;
		// try to read file
		try {
			fileReader = new BufferedReader(new FileReader(filePath));
			
			String line = fileReader.readLine();
			
			while(line != null) {	
				
				userInfoList.add(line);

				line = fileReader.readLine();
			}
			
			if (userNameExist()) {
				for(int i = 0; i < userInfoList.size(); i++) {
					if (userInfoList.get(i).equals(userName)) {
						userInfoList.remove(i + 2);
						userInfoList.add(i + 2, balance);
					}
				}
			}else {
				userInfoList.add(userName);
				userInfoList.add(passWord);
				userInfoList.add(balance);
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
		
		// try to write file
		try {
			
			fileWriter = new BufferedWriter(new FileWriter(userInfoFile));
			for(String s : userInfoList)
				fileWriter.write(s + "\n");	 	// this leaves a blank line at the end of the file that will cause the populate method to read an additional username. This shouldnt be a problem(potentially compounding lines) since the file is written new each time, and only users with passwords and balances are written

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
	}
	
	public static void updateBalance() {
		
		BufferedReader fileReader = null;
		try {
			if(!userInfoFile.exists())
				userInfoFile.createNewFile();

			fileReader = new BufferedReader(new FileReader(filePath));

			String line = fileReader.readLine();
			// rather than use a delimiter, store one parameter per line in a specific sequence
			int counter = 1;
			while(line != null) {	
				
				if(counter % 3 == 1 && userName.equals(line)) {
					break;
				}
				
				line = fileReader.readLine();
				counter++;
			}
			
			line = fileReader.readLine();
			line = fileReader.readLine();
			balance = line;

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
}
