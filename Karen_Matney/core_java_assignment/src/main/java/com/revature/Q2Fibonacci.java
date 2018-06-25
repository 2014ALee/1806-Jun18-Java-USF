/*
 * Karen Matney
 * June 21, 2018
 * Revature Training: Core Java Assignment
 * Q2Fibonacci.java
 * Code for Q2 of Core Java Assignment. Prints the first 25 numbers of the Fibonacci sequence.
 */
package com.revature;

import java.util.ArrayList;

public class Q2Fibonacci {
	public static void main(String[] args) {
		Integer[] intArray;
		intArray = fibonacci(25);

		// Prints out the fibonacci array
		for(int i : intArray) {
			System.out.println(i);
		}
	}

	public static Integer[] fibonacci(int length) {
		// n = (n-1) + (n-2)
		int n;
		int nminus1; 				// (n-1)
		int nminus2;				// (n-2)
		int finalLength = length;
		Integer[] intArray;

		// Allows variation in size to test more than one result
		ArrayList<Integer> integerArray = new ArrayList<>();

		// Getting the first to values
		nminus2 = 0;
		integerArray.add(0);
		nminus1 = 1;
		integerArray.add(1);

		for(int i = 2; i < finalLength; i++) {
			n = nminus1+ nminus2;
			integerArray.add(n);
			nminus2 = nminus1;
			nminus1 = n;
		}

		// conversion to Integer[], easier to test
		intArray = new Integer[integerArray.size()];
		integerArray.toArray(intArray);
		return intArray;
	}
}
