package com.activities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.revature.models.User;

public class Withdraw {
	
	static Scanner userInput = new Scanner(System.in);
	static User user = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void withdraw() {
		
		System.out.println("\n    +--------------Withdraw--------------+");
		
		System.out.println("Please enter the amount  you will like to withdraw");
		double withdAmount = 0;
		withdAmount = userInput.nextDouble();
		
		if(withdAmount < 0) {
			System.out.println("Error! you can't withdraw a negative value");
			System.out.println("Please try again");
			withdraw();
		}
		else if(withdAmount > 0) {
			//System.out.println("No sufficient found for the requested amount");
			//System.out.println("Your balance is: " + HelperMethods.showAmount());
			//System.out.println("Please try again ");
			System.out.println("withdraw successfull ");
			withdraw();
		}
		else {
			//user.setBalance(user.getBalance() - HelperMethods.trimedUserInput(withdAmount));
			//serializeUser(user);
			System.out.println("Withdraw successful...");
			//System.out.println("Your balance is: " + HelperMethods.showAmount());
			//System.out.println("Press 'y' to make another transaction or any key to Logout");
		}
		
		String yesNo;
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

}
