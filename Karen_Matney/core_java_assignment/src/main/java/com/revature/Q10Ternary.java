/*
 * Karen Matney
 * June 23, 2018
 * Revature Training: Core Java Assignment
 * Q10PrimePrinter.java
 * Code for Q10 of Core Java Assignment. Find the minimum using ternary operators
 */
package com.revature;

import java.util.Scanner;

public class Q10Ternary {
	public static void main(String[] args) {
		double a, b, min;
		Scanner sysIn = new Scanner(System.in);

		// Getting values
		while(true) {
			System.out.println("Enter the first number:");
			if(sysIn.hasNextInt()) {
				a = (double)sysIn.nextInt();
			} else if(sysIn.hasNextDouble()) {
				a = sysIn.nextDouble();
			} else {
				System.out.println("Invalid value. Try again.");
				continue;
			}

			System.out.println("Enter the second number:");
			if(sysIn.hasNextInt()) {
				b = (double)sysIn.nextInt();
				break;
			} else if(sysIn.hasNextDouble()) {
				b = sysIn.nextDouble();
				break;
			} else {
				System.out.println("Invalid value. Try again.");
				continue;
			}
		}

		sysIn.close();

		min = minimum(a,b);

		System.out.println("Minimum : " + min);
	}

	public static double minimum(double a, double b) {
		double min;

		min = (a > b) ? b : a;

		return min;
	}
}
