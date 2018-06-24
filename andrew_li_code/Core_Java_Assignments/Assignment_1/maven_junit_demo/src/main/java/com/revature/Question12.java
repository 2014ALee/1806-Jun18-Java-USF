package com.revature;

public class Question12 {
	// Used for recording what was printed.
	private static String printed = "";
	// Question asks us to put 100 numbers in array.
	private static int[] array = new int[100];
	
	public static void main(String[] args) {
		/*
		 * Putting numbers 1 through 100 in the array.
		 */
		for (int i = 0; i < 100; array[i] = ++i) {}
		// Printing from array if it's even.
		// Using enhanced for loop as instructed.
		for (int num : array) {
			if (num % 2 == 0) {
				System.out.println(num);
				printed += num + "\n";
			}
		}
	}
	
	public static String getPrinted() {
		return printed;
	}
	// To check what was stored in the array
	public static int getValue(int i) {
		return array[i];
	}
}
