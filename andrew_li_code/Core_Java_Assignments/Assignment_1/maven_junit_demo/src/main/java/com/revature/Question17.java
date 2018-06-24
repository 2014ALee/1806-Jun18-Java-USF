package com.revature;

import java.util.Scanner;

public class Question17 {
	
	public static void main(String[] args) {
		// A double storing user input is useful down the line.
		// We will repeat a loop until user gives a valid input.
		Scanner scan = new Scanner(System.in);
		boolean needValidInput = true;
		while (needValidInput) {
			// Prompts the user for the input.
			// Declares the variables for us to use outside
			// of the try.
			System.out.println("Enter amount, interest rate, and number of years.");
			// We let the user input the strings ahead of time so we can use them
			// in a function.
			System.out.print("Principal amount: ");
			String userInput = scan.nextLine();
			System.out.println("");

			System.out.print("Interest rate (in decimal, not percent) per year: ");
			String userInput2 = scan.nextLine();
			System.out.println("");

			System.out.print("Number of years: ");
			String userInput3 = scan.nextLine();
			System.out.println("");
			// Close Scanner.
			
			String output = getPrintedStatement(userInput, userInput2,
					userInput3);
			System.out.println(output);
			if (output.substring(0, 10).equals("The simple")) {
				needValidInput = false;
			}
		}
		scan.close();
	}
	// Allows the program to input strings rather than rely on colsole/
	public static String getPrintedStatement(String s1, String s2, String s3) {
		/*
		 * Initialize them to negative. If the user doesn't enter valid number
		 * or enters negative, it stays below zero. For these values, we want
		 * positive for all of them in order for it to make sense. 0 does not
		 * cont as a positive.
		 */
		double principal = -1;
		double rate = -1;
		double time = -1;
		String returnStr = "";
		try { principal = Double.parseDouble(s1); } catch (NumberFormatException e) {}
		try { rate = Double.parseDouble(s2); } catch (NumberFormatException e) {}
		try { time = Double.parseDouble(s3); } catch (NumberFormatException e) {}
		// Returning string rather than print, so junit can test.
		if (principal <= 0) {
			returnStr += "The principal amount must be represented by a "
					+ "number greater than 0, the following input was invalid: "
					+ s1 + "\n";
		}
		if (rate <= 0) {
			returnStr += "The interest rate must be represented by a "
					+ "number greater than 0, the following input was invalid: "
					+ s2 + "\n";
		}
		if (time <= 0) {
			returnStr += "The number of years must be a number greater than 0, "
					+ " the following input was invalid: " + s3 + "\n";
		}
		if (returnStr.length() == 0) {
			return "The simple interest is " + principal * rate * time;
		}
		else {
			return returnStr;
		}
		
	}
}
