package com.revature;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question16 {
	private static String printedStatement;
	
	public static void main(String[] args) {
		/*
		 * If no arguments are passed, there are no characters.
		 */
		if (args.length == 0) {
			System.out.println("The number of characters in the input is 0.");
		}
		/*
		 * The following prints based on the arguments passed
		 * into the main method. Arguments can be passed through
		 * the run configurations.
		 * If there is one or more argument(s) passed,
		 * there are some characters. Arguments after
		 * the first one are separated by spaces (which is 
		 * one additional character).
		 */
		else {
			int charCount = args[0].length();
			for (int i = 1; i < args.length; i++) {
				charCount += args[i].length() + 1;
			}
			printedStatement = "The number of characters in the input is "
					+ charCount + "."
			System.out.println(printedStatement);
			
		}
	}
}
