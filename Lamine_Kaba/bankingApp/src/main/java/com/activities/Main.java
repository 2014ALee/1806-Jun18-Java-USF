package com.activities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.revature.models.User;

public class Main {
	
	static Scanner userInput = new Scanner(System.in);
	static User user = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void mainMenu() {

		String userInput;

		System.out.println("\n    +--------------MAIN MENU--------------+");
		System.out.println("          Welcome To Your Bank");
		System.out.println("Please choose an option");
		

		System.out.println("[1] - Login");
		System.out.println("[2] - Register");
		System.out.print("Selection: ");

		try {
			userInput = br.readLine();

			switch(userInput) {
			case "1":
				System.out.println("Navigating to Login Menu...");
				Login.login();
				break;
			case "2":
				System.out.println("Navigating to Registration Menu...");
				Register.register();
				break;
			default:
				System.out.println("Invalid selection, please try again.\n");
				mainMenu();
			}

		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from console ");
			e.printStackTrace();
		}

	}

}
