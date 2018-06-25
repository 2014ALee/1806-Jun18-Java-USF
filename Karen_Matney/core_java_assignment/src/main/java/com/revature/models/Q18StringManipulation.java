/*
 * Karen Matney
 * June 23, 2018
 * Revature Training: Core Java Assignment
 * Q18StringManipulation.java
 * Code for Q18 of Core Java Assignment. Implementing class for three different string manipulations:
 * finding any uppercase, making it all uppercase, and converting to an int and adding ten.
 */
package com.revature.models;

import java.util.Locale;

public class Q18StringManipulation extends Q18StringManipulationAbstract {
	@Override
	public boolean anyUppercase(String str) {
		// Used a regular expression to find Uppercase
		if(str.matches(".*[A-Z].*")) return true;
		else return false;
	}

	@Override
	public String allUppercase(String str) {
		return str.toUpperCase(Locale.US);
	}

	@Override
	public void convertAddten(String str) {
		int integer;
		// Useed a regular expression to find digits
		if(str.matches("^\\d+$")) {
			/*
			 * Integer.decode(nm) does a similar conversion to the Integer class and accepts non-decimal numbers.
			 * It works, but Integer.parseInt(s) is more specific, only accepting decimals.
			 */
			integer = Integer.parseInt(str);
			integer += 10;
			System.out.println(integer);
		}
		else {
			System.out.print("Not an integer");
		}
	}

}