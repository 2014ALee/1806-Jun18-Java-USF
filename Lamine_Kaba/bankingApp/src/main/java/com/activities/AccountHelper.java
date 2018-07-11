package com.activities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.models.Account;
import com.revature.models.User;

public class AccountHelper {
	
	static Scanner userInput = new Scanner(System.in);
	static User user = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void account() {
		
		String strUserInput;

		System.out.println("What account would you like to create?");
		System.out.println("Please choose an option");


		System.out.println("[1] - Checking");
		System.out.println("[2] - Savings");
		System.out.println("[3] - Logout");
		System.out.print("Selection: ");

		try {
			strUserInput = br.readLine();
			Account account = new Account();
			switch(strUserInput) {
			case "1":
				//System.out.println("For checking account, minimum deposite is 20.00");
				System.out.println("Please enter your deposite amount: ");
				double checkingDeposite;
				checkingDeposite = userInput.nextDouble();
				account.setChecking(checkingDeposite);
				if(checkingDeposite <0.00) {
					System.out.println("You did not deposite the minimum required; please try again");
					account();
				}else {
					user = new User();
					user = Activity.user;
					System.out.println(user.getUserId());
					
					account.setUserid(user.getUserId());
					AccountDAO accountDAO = new AccountDAOImpl();
					accountDAO.addAccount(account);
					System.out.println("Checking account created successfully...");
				}
				
				Activity.activities();
				break;
			case "2":
				//System.out.println("For Savings account, minimum deposit is 50.00");
				System.out.println("Please enter your deposite amount: ");
				double savingsDeposite;
				savingsDeposite = userInput.nextDouble();
				account.setSaving(-savingsDeposite);
				if(savingsDeposite <0.00) {
					System.out.println("You did not deposite the minimum required; please try again");
					account();
				}else {
					user = new User();
					user = Activity.user;
					System.out.println(user.getUserId());
					
					account.setUserid(user.getUserId());
					AccountDAO accountDAO = new AccountDAOImpl();
					accountDAO.addAccount(account);
					System.out.println("Savings account created successfully...");
				}
				
				Activity.activities();
				break;
			case "3":
				HelperMethods.logout();
				break;
			default:
				System.out.println("Invalid selection, please try again.\n");
				account();
			}

		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from console ");
			e.printStackTrace();
		}

	}

}



