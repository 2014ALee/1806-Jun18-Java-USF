package com.activities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.revature.models.User;

public class CheckBalance {
	
	static Scanner userInput = new Scanner(System.in);
	static User user = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void checkBalance() {
		
		System.out.println("\n    +--------------CheckBanlance--------------+");
		
		System.out.println("Your balance is: " + HelperMethods.showAmount());
		System.out.println("Press 'y' to make another transaction or any key to Logout");
		
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
