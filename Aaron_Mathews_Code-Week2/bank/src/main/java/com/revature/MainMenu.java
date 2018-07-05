package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void mainMenu() {
		String userInput;

		System.out.println("-----------MAIN MENU-----------");
		System.out.println("(Enter the number of the option you would like to choose)");
		System.out.println("[1] Create an account\n[2] Login");

		try {
			userInput = br.readLine();
			switch(userInput) {
			case "1":
				AccountMenu.createAccount();
				break;
			case "2":
				AccountMenu.login();
				break;
			default:
				System.out.println("Invalid input. Please try again.");
				mainMenu();
			}
		} catch (IOException e) {
			System.out.println("There was an error while reading input.\nPlease try again.");
			mainMenu();
		}
	}

}
