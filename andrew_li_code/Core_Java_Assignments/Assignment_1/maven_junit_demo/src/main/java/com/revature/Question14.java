package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Question14 {
	
	/*
	 * Initialize these variables so we can use them later on.
	 * Private because we're only using it here.
	 */
	
	// Taking the input to make our decision.
	private static String userInput = "";
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	// Question asked us to store stuff in an array,
	// so this array is initialized.
	private static String[] storedArray = new String[0];
	// The String mentioned in this problem.
	private final static String OUR_STRING = "I am learning Core Java";
	
	
	public static void main(String[] args) {
		/*
		 * We want to wait until the user selects a
		 * proper input.
		 */
		boolean waiting = true;
		
		while (waiting) {
			/*
			 * We're switching between 1, 2, and 3,
			 * so prompt user for one of those.
			 */
			System.out.print("Enter 1, 2, or 3: ");
			try {
				userInput = br.readLine();
			} catch (IOException e) {
				System.out.println("Error in reading input...");
				e.printStackTrace();
			}
			System.out.println("");
			

			boolean needNumber = true;
			double number = -1.1;
			
			/*
			 * We want the user's input of a number.
			 */
			if (userInput.equals("1")) {
				while (needNumber) {
					System.out.print("Enter a number: ");
					try {
						userInput = br.readLine();
						number = Double.parseDouble(userInput);
						// If it reaches this point, we're ready
						// to end the loop.
						needNumber = false;
					// Taking input has a risk of IOException.
					} catch (IOException e) {
						System.out.println("Error in reading input...");
						e.printStackTrace();
					// Parsing a number has a risk of a parse exception.
					} catch (NumberFormatException e) {
						System.out.println("Your input "
								+ "\"" + userInput + "\" is not a number");
					} 
				}
			}

			
			// The switch statement asked of this problem.
			// If 1, 2 or 3, no need to repeat, so end loop and break.

			String output = getPrinted(userInput, number);
			if (output.length() > 0) {
				waiting = false;
				System.out.println(output);
			}
			else {
				waiting = true;
			}
		}
		
	}
	// Formatting the date as a string.
	public static String getDate() {
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date ourDate = new Date();
		return format.format(ourDate);
	}
	// Simplified portion of solving root.
	public static double solveRoot(double input) {
		return Math.pow(input, 0.5);
	}
	// One of the stuff asked from a switch case.
	public static String[] splitArray(String sentence) {

		String[] splittedString = sentence.split(" ");
		storedArray = new String[splittedString.length];
		for (int i = 0; i < splittedString.length; i++) {
			storedArray[i] = splittedString[i];
		}
		return splittedString;
	}
	public static String getPrinted(String input, double number) { 
		switch (input) {
		// Root solving is defined below.
		case "1":
			double value = solveRoot(number);
			return "The square root of " + input + " is " + value + ".";
		// Displaying the date.
		case "2":
			DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			return "Today's date is " + format.format(new Date());
		// Splitting the string and storing it.
		case "3":
			storedArray = splitArray(OUR_STRING);
			return "Stored array: " + Arrays.toString(storedArray);
		// In case user enters in wrong input...
		case "1, 2, or 3":
		case "1, 2, or 3:":
		case "1, 2, or 3: ":
			System.out.println("Don't copy, choose one of the three");
			return "";
		default:
			System.out.println("Incorrect input.");	
			return "";
		}
	}
}
