/*
 * Karen Matney
 * June 23, 2018
 * Revature Training: Core Java Assignment
 * Q12ArrayPrintEven.java
 * Code for Q12 of Core Java Assignment. Store sequential numbers in an array, print out only the evens.
 */
package com.revature;


public class Q12ArrayPrintEven {
	public static void main(String[] args) {
		int[] intArray;
		int size = 100;
		
		intArray = new int[size];
		
		// Setting up the numbers
		for(int i = 0; i < size; i++) {
			intArray[i] = i+1;
		}
	
		// Printing out evens
		for(int i : intArray) {
			if(isEven(i))
				System.out.println(i);
		}
	}
	
	// Finding the even numbers
	public static boolean isEven(int i) {
			if((i % 2) == 0)
				return true;
			else
				return false;
	}
}
