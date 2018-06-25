package com.revature.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu {

	public static String getUserInput(BufferedReader br) {

		// string to store user input
		String userInput;

		System.out.println("\n-------------MAIN MENU-------------");

		System.out.println("[1] - Login");
		System.out.println("[2] - Register");
		System.out.println("[3] - Exit");
		System.out.print("Selection: ");

		try {
			// get user input from main menu
			userInput = br.readLine();


		} catch (IOException ioe) {
			// System.out.println("[LOG] - Error while reading from console");
			// e.printStackTrace();
		}
		
		return userInput;
	}	
}
