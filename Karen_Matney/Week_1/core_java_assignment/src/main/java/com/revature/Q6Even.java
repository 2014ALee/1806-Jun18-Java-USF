/*
 * Karen Matney
 * June 23, 2018
 * Revature Training: Core Java Assignment
 * Q6Even.java
 * Code for Q6 of Core Java Assignment. Tells if a number is even without the modulo operator.
 */
package com.revature;

import java.util.Scanner;

public class Q6Even {
	public static void main(String[] args) {
		int num;

		Scanner sysIn = new Scanner(System.in);

		System.out.println("Type a number:");

		// Checking if input is of type int
		if(sysIn.hasNextInt()) {
			num = sysIn.nextInt();

			// Even-not even print out
			if(isEven(num)) System.out.println(num + " is even");
			else System.out.println(num + " is not even");

		} else {
			System.out.println("Not an integer");

			sysIn.close();

			return;
		}

		sysIn.close();
	}

	// Used subtraction/addition to determine if even or odd
	public static boolean isEven(int i) {
		if(i == 0) return true;

		// Postive numbers
		if(i > 0) {
			for(int j = i; j > 0; j -= 2) i -= 2;

			if(i== 0) {
				return true;
			} else {
				return false;
			}

			// Negative numbers
		} else {
			for(int j = i; j < 0; j += 2) i += 2;

			if(i== 0) {
				return true;
			} else {
				return false;
			}
		}
	}
}