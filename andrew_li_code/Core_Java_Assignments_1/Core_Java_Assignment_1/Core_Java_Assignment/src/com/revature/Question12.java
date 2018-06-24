package com.revature;

public class Question12 {
	public static void main(String[] args) {
		// Question asks us to put 100 numbers in array.
		int[] array = new int[100];
		/*
		 * Putting numbers 1 through 100 in the array.
		 */
		for (int i = 0; i < 100; array[i] = ++i) {}
		// Printing from array if it's even.
		// Using enhanced for loop as instructed.
		for (int num : array) {
			if (num % 2 == 0) {
				System.out.println(num);
			}
		}
	}
}
