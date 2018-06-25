/*
 * Karen Matney
 * June 23, 2018
 * Revature Training: Core Java Assignment
 * Q4Factorial.java
 * Code for Q4 of Core Java Assignment. Returns the value of N factorial
 */
package com.revature;

import java.util.Scanner;

public class Q4Factorial {
	public static void main(String[] args) {
		Scanner sysIn = new Scanner(System.in);
		int factorial = 10; // if n! value of n

		System.out.print("Input the factorial you wish to calculate: ");
		if(sysIn.hasNextInt()) {
			factorial = sysIn.nextInt();;
		} else {
			System.out.print("Invalid Value");
			sysIn.close();
			return;
		}

		sysIn.close();

		// Prints value of factorial
		factorial = factorialCalc(factorial);
		if(factorial != -1)
			System.out.println("Result: " + factorial);
		else
			System.out.println("Negatives don't have factorials");
	}

	public static int factorialCalc(int factorial) {
		int factorialProduct = 1;
		System.out.println(factorial);
		// 0! = 1. Rest are n * (n-1) * (n-2) * (n-3)...*1
		if(factorial == 0) {
			return factorialProduct;	
		} else if (factorial > 0){
			for(int i = factorial; i > 0; i--) {
				factorialProduct *= i;
			}

		} else {
			return -1;
		}

		return factorialProduct;
	}
}