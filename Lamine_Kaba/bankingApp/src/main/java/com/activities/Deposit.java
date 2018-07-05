package com.activities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class Deposit {

	static Scanner userInput = new Scanner(System.in);
	static User user = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static AccountDAOImpl acc = new AccountDAOImpl();

	public static void deposit(Account acc) {
		
		Account newAcc = new Account();


		System.out.println("\n    +--------------Deposit--------------+");

		System.out.println("Which account would you like to make a deposit?");
		System.out.println("Please choose an option");

		System.out.println("[1] - Checking");
		System.out.println("[2] - Savings");
		System.out.print("Selection: ");

		try {
			
			String strInput;
			strInput = br.readLine();

			switch(strInput) {
			case "1":
				System.out.println("Please enter the amount you will like to deposit");
				double depoAmount = 0;

				depoAmount = userInput.nextDouble();

				if(depoAmount <= 0) {
					System.out.println("Error! you can't deposit a negative value");
					System.out.println("Please try again");
					deposit(newAcc);
				}
				else {	
					
					newAcc.setChecking(depoAmount);
				
					
					
					
					
					
					
					user.setBalance(user.getBalance() + HelperMethods.trimedUserInput(depoAmount));
					
					System.out.println("Deposit successful...");
					System.out.println("Do you want to check you balance?\nPress 'y' to make another transaction or any key to Logout");
				}

				String yesNo;
				try {
					yesNo = br.readLine();
					if(yesNo.toLowerCase().equals("y")) {
						System.out.println("Your balance is: " + HelperMethods.showAmount());
						System.out.println("Press 'y' to make another transaction or any key to Logout");
						//String yesNo;
						try {
							yesNo = br.readLine();
							if(yesNo.toLowerCase().equals("y")) {
								Activity.activities();
							}
							else {
								HelperMethods.logout();
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else {
						HelperMethods.logout();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			case "2":
				System.out.println("Navigating to Registration Menu...");
				Register.register();
				break;
			default:
				System.out.println("Invalid selection, please try again.\n");
				Main.mainMenu();
			}

		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from console ");
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		

		System.out.println("Please enter the amount you will like to deposit");
		double depoAmount = 0;

		depoAmount = userInput.nextDouble();

		if(depoAmount <= 0) {
			System.out.println("Error! you can't deposit a negative value");
			System.out.println("Please try again");
			deposit();
		}
		else {
			user.setBalance(user.getBalance() + HelperMethods.trimedUserInput(depoAmount));
			//serializeUser(user);
			System.out.println("Deposit successful...");
			System.out.println("Do you want to check you balance?\nPress 'y' to make another transaction or any key to Logout");
		}

		String yesNo;
		try {
			yesNo = br.readLine();
			if(yesNo.toLowerCase().equals("y")) {
				System.out.println("Your balance is: " + HelperMethods.showAmount());
				System.out.println("Press 'y' to make another transaction or any key to Logout");
				//String yesNo;
				try {
					yesNo = br.readLine();
					if(yesNo.toLowerCase().equals("y")) {
						Activity.activities();
					}
					else {
						HelperMethods.logout();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				HelperMethods.logout();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void deposit() {
		// TODO Auto-generated method stub
		
	}

}
