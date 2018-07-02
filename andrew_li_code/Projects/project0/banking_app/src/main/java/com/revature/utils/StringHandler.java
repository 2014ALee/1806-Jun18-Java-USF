package com.revature.utils;

public class StringHandler {
	public static boolean isAlphaNumeric(String str) {
		// Make lower case to upper case for
		// ease of comparison.
		str = str.toUpperCase();
		// If the first character is not Alphabetic,
		// return false;
		if (str.length() == 0 || str.charAt(0) < 'A'
				|| str.charAt(0) > 'Z') {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			// Get the ascii value of character.
			int asciiVal = (int) (str.charAt(i));
			/*
			 * This would shift the value to the
			 * ascii value of an uppercase letter
			 * if we have an ascii value of a
			 * numeric character.
			 */
			if (asciiVal < 58) {
				asciiVal += 17;
			}
			/*
			 * After changing ascii's of lowercase letters
			 * and numeric characters to uppercase
			 * ascii values, if it's still outside
			 * of the range, we have a non-alphanumeric
			 * character.
			 */
			if (asciiVal < 65 || asciiVal > 90) {
				return false;
			}
		}
		return true;
	}
	/*
	 * Generating a String hash for a password.
	 */
	public static String hash(String password) {
		String current = "";
		for (int i = 0; i < 10; i++) {
			int num = (i + password + i).hashCode();
			if (num < 0) {
				num *= -1;
			}
			current += num;
		}
		return current;
	}
	/*
	 * Fix user command if user made a reasonable mistake.
	 */
	public static String fixCommand(String command) {
		command = command.trim();
		int lastInd = command.length() - 1;
		if (command.charAt(0) == '[' && command.charAt(lastInd)
				== ']') {
			command = command.substring(1, lastInd);
		}
		return command;
	}
	/*
	 * Check if there's more than two digits the first dot.
	 */
	public static boolean threeDot(String test) {
		int index = test.indexOf('.');
		if (index >= 0 && index < test.length() - 3) {
			return true;
		}
		return false;
	}
}
