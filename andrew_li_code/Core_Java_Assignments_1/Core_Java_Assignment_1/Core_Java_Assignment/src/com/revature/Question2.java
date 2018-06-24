package com.revature;

public class Question2 {

	public static void main(String[] args) {
		displayFibonacci(0, 1);
	}
	public static void displayFibonacci(int smaller, int bigger) {
		// first and second number are predefined
		System.out.println(smaller);
		System.out.println(bigger);
		
		/*
		 * The third is the first to be determined through
		 * the sum. We want to keep printing until we get
		 * the 25th of the sequence.
		 */
		for (int i = 3; i <= 25; i++) {
			int sum = smaller + bigger;
			System.out.println(sum);
			/*
			 * Following the rules of fibbonacci,
			 * the bigger becomes the smaller and the
			 * sum becomes the bigger
			 */
			smaller = bigger;
			bigger = sum;
		}
	}
}
