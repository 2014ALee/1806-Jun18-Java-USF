package com.revature.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHandler {
	/*
	 * Make it easier to prompt user.
	 */
	public static String promptUser(String message) {
		String output = null;
		boolean needValidInput = true;
		/*
		 * Repeat until we get a valid output.
		 */
		while (needValidInput) {
			System.out.print(message);
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
			/*
			 * Reading the user input
			 * Repeat if we don't get an input.
			 */
			try {
				output = br.readLine();
				needValidInput = false;
				System.out.println("");
			} catch (IOException e) {
				System.out.println("");
				e.printStackTrace();
				System.out.println("Enter a valid input.");
			}
			/*
			 * Attempting to close the reader.
			 */
/*			try {
				br.close();
				System.out.println("Closed");
			} catch (IOException e) {
				System.out.println("");
				e.printStackTrace();
				System.out.println("Error while trying to close");
			}*/
		}
		
		return output;
	}
	/*
	 * Same as regular prompt, except it's prompting for
	 * a double.
	 */
	public static double promptNumber(String message) {
		double output = -1;
		boolean needValidInput = true;
		/*
		 * Repeat until we get a valid output.
		 */
		while (needValidInput) {
			System.out.print(message);
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
			/*
			 * Reading the user input
			 * Repeat if we don't get an input.
			 */
			String userInput = null;
			try {
				userInput = br.readLine();
				output = Double.parseDouble(userInput);
				if (StringHandler.threeDot(userInput)) {
					System.out.println("\nPlease include no "
							+ "more than two digits after a "
							+ "dot.");
				}
				else {
					needValidInput = false;
				}
				System.out.println("");
			} catch (IOException e) {
				System.out.println("");
				e.printStackTrace();
				System.out.println("Enter a valid input.");
				/*
				 * In the case of an invalid number,
				 * tell the user that the number is invalid.
				 */
			} catch (NumberFormatException e) {
				System.out.println("Your input "
						+ "\"" + userInput + "\" is not a number");
			}
			
		}
		
		return output;
	}
}
