/*
 * Karen Matney
 * June 23, 2018
 * Revature Training: Core Java Assignment
 * Q3ReverseString.java
 * Code for Q3 of Core Java Assignment. Reverses a string without a temporary variable.
 * 
 * Help from: Christian (said he used concat to append it to the rest of the string)
 */
package com.revature;

import java.util.Scanner;

public class Q3ReverseString {
	public static void main(String[] args) {
		String reversed = "";
		Scanner sysIn = new Scanner(System.in);

		// Allowing user input
		System.out.println("Type the string you want reversed: ");

		if(sysIn.hasNext()) {
			reversed = sysIn.next();
		} else {
			System.out.println("Invalid input");
			sysIn.close();
			return;
		}

		sysIn.close();

		// Printing out the reverse
		System.out.println(reverse(reversed));
	}

	// Concat the each character of string in reverse order, then return substring
	static String reverse(String reversed) {
		int length = 0;

		length = reversed.length();

		for(int i = length-1; i >= 0; i--) {
			reversed = reversed.concat(Character.toString(reversed.charAt(i)));
		}

		reversed = reversed.substring(length,reversed.length());

		return reversed;
	}
}
