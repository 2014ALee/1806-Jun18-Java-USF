package com.revature;

import java.util.Scanner;

public class Question17 {
	
	public static void main(String[] args) {
		// A double storing user input is useful down the line.
		double principal = 0.0;
		double rate = 0.0;
		double time = 0.0;
		// We will repeat a loop until user gives a valid input.
		boolean needValidInput = true;
		while (needValidInput) {
			// Prompts the user for the input.
			// Declares the variables for us to use outside
			// of the try.
			System.out.println("Enter amount, interest rate, and number of years.");
			String userInput = "";
			Scanner scan = new Scanner(System.in);
			try {
				// Attempts to parse user input into
				// a double. If user enters something
				// invalid, inform user and restart the loop.
				System.out.println("Principal amount: ");
				userInput = scan.nextLine();
				System.out.println("");
				principal = Double.parseDouble(userInput);
				System.out.println("Interest rate (in decimal, not percent) per year: ");
				userInput = scan.nextLine();
				System.out.println("");
				rate = Double.parseDouble(userInput);
				System.out.println("Number of years: ");
				userInput = scan.nextLine();
				System.out.println("");
				time = Double.parseDouble(userInput);
				needValidInput = false;
				scan.close();
			}
			// When user doesn't enter a proper number.
			catch (NumberFormatException e) {
				System.out.println("Your input "
						+ "\"" + userInput + "\" is not a number");
			}
		}
		// After we get the inputs, it's time to display.
		System.out.println("The simple interest is " + principal * rate * time);
	}
}
