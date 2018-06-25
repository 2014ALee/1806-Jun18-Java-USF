/*
 * Karen Matney
 * June 23, 2018
 * Revature Training: Core Java Assignment
 * Q5Substring.java
 * Code for Q5 of Core Java Assignment. Returns a substring (from the beginning) without using the methods from
 * String, StringBuffer, or StringBuilder.
 */
package com.revature;

import java.util.Scanner;

public class Q5Substring {
	public static void main(String[] args) {
		String str;
		int idx;
		Scanner sysIn = new Scanner(System.in);

		// Grabbing the string
		System.out.println("Type the string: ");

		if(sysIn.hasNext()) {
			str = sysIn.next();
		} else {
			System.out.println("Invalid input");
			sysIn.close();
			return;
		}

		// Grabbing the index
		System.out.println("Type the number of the last index: ");

		if(sysIn.hasNextInt()) {
			idx = sysIn.nextInt();
		} else {
			System.out.println("Not an integer");
			sysIn.close();
			return;
		}

		sysIn.close();

		// Printing substring
		System.out.println(substring(str,idx));
	}

	// Used a second variable and concated the original string to it up to the but not including idx.
	static String substring(String str,int idx) {
		String substr = new String();
		for(int i = 0; i < idx; i++) {
			substr = substr.concat(Character.toString(str.charAt(i)));
		}

		return substr;
	}
}
