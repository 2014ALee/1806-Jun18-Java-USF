package com.revature.utils;

import com.revature.exceptions.InvalidNumberException;
import com.revature.exceptions.NegativeAmountException;
import com.revature.exceptions.TooManyDigitsPastDecimalException;

public class BasicHelpers {

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
		for (int i = 0; i < 5; i++) {
			int num = (i + password + i).hashCode();
			if (num < 0) {
				num *= -1;
			}
			current += num;
		}
		return current;
	}
	
	private static boolean invalidDecimal(String test) {
		int index = test.indexOf('.');
		if (index >= 0 && index < test.length() - 3) {
			return true;
		}
		return false;
	}
	
	/*
	 * For clients, we want to be able to show the amount
	 * in dollars.
	 */
	public static String toDollarString(long longAmount) {
		String output = "";
		if (longAmount < 10) {
			output = "0.0" + longAmount;
		} else if (longAmount < 100) {
			output = "0." + longAmount;
		}
		else {
			output += (longAmount / 100);
			int afterDec = (int) (longAmount % 100);
			if (afterDec < 10) {
				output += ".0";
			}
			else {
				output += ".";
			}
			output += afterDec;
		}
		return output;
	}
	
	/*
	 * We will want to be able to take in dollar amount
	 * inputs from clients.
	 */
	public static long fromDollarString(String dollarString) throws InvalidNumberException,
			NegativeAmountException, TooManyDigitsPastDecimalException {
		double fromString = -1;
		try {
			fromString = Double.parseDouble(dollarString);
		} catch (NumberFormatException e) {
			throw new InvalidNumberException();
		}
		if (fromString < 0) {
			throw new NegativeAmountException();
		}
		if (invalidDecimal(dollarString)) {
			throw new TooManyDigitsPastDecimalException();
		}
		return Math.round(fromString * 100);
	}

}
