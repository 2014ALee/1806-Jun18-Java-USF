package com.revature;

import java.util.Scanner;

import com.revature.models.userData;

public class menuDriver extends mainDriver {
	public static Scanner input = new Scanner(System.in);
	public static Scanner loggedInput = new Scanner(System.in);
	public static userData theUser = null;

	public static void mainMenu() {
		String userInput;

		System.out.println("======================Main Menu========================");
		System.out.println("=======================================================");

		System.out.println("==================Enter \"1\" to log in==================");
		System.out.println("==================Enter \"2\" to Register================");
		System.out.println("===========Enter \"3\" to Terminate the Program==========");
		System.out.print("User >");
		userInput = input.nextLine();
		switch(userInput) {
		case "1":
			System.out.println("===================Logging in=======================");
			loginDriver.login();
			break;
		case "2":
			System.out.println("============Loading Registration Menu===============");
			registerDriver.register();
			break;
		case "3":
			System.out.println("===================Goodbye==========================");
			System.exit(0);
			break;
		default:
			System.out.println("============Invalid input, try again================");
			mainMenu();

		}


	}
	public static void loggedInMenu(String userName, String password) {
		double inputNum;
		System.out.println("======================Welcome "+ theUser.getFirstName()+"========================");

		System.out.println("==================Enter \"1\" to view balance==================");
		System.out.println("==================Enter \"2\" to make deposits=================");
		System.out.println("==================Enter \"3\" to make withdrawls===============");
		System.out.println("=====================Enter \"4\" to Log Out====================");
		System.out.print(theUser.getUserName()+" >");
		String userInput = input.nextLine();
		switch(userInput) {
		case "1":
			System.out.println("====================BALANCE========================");
			System.out.println("Balance: $"+theUser.getBalance());
			loggedInMenu(userName, password);
			break;
		case "2":
			System.out.println("==============ENTER DEPOSIT AMOUNT=================");
			System.out.print(theUser.getUserName()+" >");
			inputNum =loggedInput.nextDouble();
			transactionDriver.deposit(theUser, inputNum);
			System.out.println("============Current Balance: $"+theUser.getBalance()+"==============");
			loggedInMenu(userName, password);
			break;
		case "3":
			System.out.println("============ENTER WITHDRAWL AMOUNT=================");
			System.out.print(theUser.getUserName()+" >");
			inputNum = loggedInput.nextDouble();
			transactionDriver.withdraw(theUser, inputNum);
			System.out.println("============Current Balance: $"+theUser.getBalance()+"==============");
			loggedInMenu(userName, password);
			break;
		case "4":
			System.out.println("===================Goodbye "+theUser.getUserName()+"==========================");
			logout();
			break;
		default:
			System.out.println("=========Please select one of the options.==========");
			System.out.println("============Invalid input, try again================");
			loggedInMenu(userName, password);

		}

	}
	private static void logout() {
		theUser = null;
		mainMenu();

	}

}
