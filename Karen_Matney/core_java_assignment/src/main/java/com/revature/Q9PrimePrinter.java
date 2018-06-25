/*
 * Karen Matney
 * June 23, 2018
 * Revature Training: Core Java Assignment
 * Q9PrimePrinter.java
 * Code for Q9 of Core Java Assignment. Driver code for employee sort.
 */
package com.revature;

import java.util.ArrayList;

public class Q9PrimePrinter {
	public static void main(String[] args) {
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		boolean isPrime = true;
		
		// ArrayList of numbers 1-100
		for(int i = 1; i <=100; i++) {
			intArray.add(i);
		}
		
		// Testing for prime
		for(int i : intArray) {
			if(i == 1) {
				isPrime = false;
			}
			else {
				for(int j = 2; j <= i/2; j++) {
					if((i % j) == 0) {
						isPrime = false;
						break;
					}
				}
			}
			
			// Prints of if it is
			if(isPrime) {
				System.out.println(i);
			}
			isPrime = true;
		}
	}
}
