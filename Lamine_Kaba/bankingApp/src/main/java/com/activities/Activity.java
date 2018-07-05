package com.activities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.Account;
import com.revature.models.User;

public class Activity {
	
	static Scanner userInput = new Scanner(System.in);
	static User user = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Account acc = new Account();
	
	public static void activities() {
		
		UserDAO userDao = new UserDAOImpl();
		
		user = userDao.getUserByName(Login.user.getUsername());
		
		System.out.println("Id = " +user.getUserId());
		
		System.out.println("\n    +--------------Activities--------------+");
		
		System.out.println("What you would like to do?");
		
		System.out.println("[1] - Deposit");
		System.out.println("[2] - Withdraw");
		System.out.println("[3] - View balance");
		System.out.println("[4] - LogOut");
		System.out.println("[5] - Create New Account");
		System.out.print("Selection: ");
		
		String userInput;
		
		try {
			userInput = br.readLine();

			switch(userInput) {
			case "1":
				System.out.println("Navigating to deposit...");
				Deposit.deposit(acc);
				break;
			case "2":
				System.out.println("Navigating to Withdraw...");
				Withdraw.withdraw();
				break;
			case "3":
				System.out.println("Navigating to Balance...");
				ViewBalance.viewBalance();;
				break;
			case "4":
				System.out.println(" ");
				HelperMethods.logout();;
				break;
			case "5":
				System.out.println(" ");
				AccountHelper.account();;
				break;
			default:
				System.out.println("Invalid selection, please try again.");
				activities();
			}

		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from console ");
			e.printStackTrace();
		}
		
	}

}
