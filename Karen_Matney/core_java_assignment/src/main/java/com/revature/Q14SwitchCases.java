/*
 * Karen Matney
 * June 23, 2018
 * Revature Training: Core Java Assignment
 * Q14SwitchCases.java
 * Code for Q14 of Core Java Assignment. Has a switch statement with one of three options:
 * finding the square root of a number, displaying today's date, converting 'I am learning
 * Java' to a string array.
 */
package com.revature;

import java.util.Date;
import java.util.Scanner;

public class Q14SwitchCases {
	public static void main(String[] args) {
		Scanner sysIn = new Scanner(System.in);

		switchMenu(sysIn);

		sysIn.close();
	}

	public static void switchMenu(Scanner scan) {
		int value = 0;

		// Switch statement options
		System.out.println("[1]: Find the square root of a number");
		System.out.println("[2]: Display today's date");
		System.out.println("[3]: 'I am learning core Java' in a string array");

		// Switch statement commenced on a valid input
		if(scan.hasNextInt()) {
			value = scan.nextInt();

			switch(value) {
			case 1: // square root
				squareRoot(scan);
				break;
			case 2: //Current date
				System.out.println(new Date((long)System.currentTimeMillis()));
				break;
			case 3: // Splitting a string into an array of strings
			{
				String str = "I am learning Core Java.";
				String[] strArray;

				System.out.println("String to split: " + str);

				System.out.println("Splitting string");
				strArray = str.split(" ");

				System.out.println("Proof?");
				for(String s : strArray) {
					System.out.println(s);
				}
			}
			break;
			default:
				System.out.println("Not an option. Please try again");
				switchMenu(scan);
				break;
			}
		} else {
			System.out.println("Not an option. Please try again.");
			scan.next();
			switchMenu(scan);
		}
	}

	private static void squareRoot(Scanner scan) {
		double num;

		System.out.println("Enter the number you wish to square root:");

		// Getting user input. Finding the square root on a successful input
		if(scan.hasNextDouble()) {
			num = scan.nextDouble();
			if(num > -1) {
				System.out.println(Math.sqrt(num));
				return;
			}
		}
		System.out.println("Invalid Input. Try Again.");
		scan.next();
		squareRoot(scan);
	}
}
