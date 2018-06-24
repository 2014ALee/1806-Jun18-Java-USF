package com.revature;

public class Question2 {

	public static void main(String[] args) {
		int[] fibonacciNumbers = generateFibonacciSeqence(25);
		for (int i = 0; i < fibonacciNumbers.length; i++) {
			System.out.println(fibonacciNumbers[i]);
		}
	}
	/*
	 * Create an array showing the numbers in a fibonacci sequence.
	 */
	public static int[] generateFibonacciSeqence(int number) {
		/*
		 * Fibonacci has a predefined value for the
		 * first and second in the sequence.
		 */
		if (number < 1) {
			return new int[0];
		} else if (number == 1) {
			return new int[] { 0 };
		} else if (number == 2) {
			return new int[] { 0, 1};
		}
		/*
		 * We will need to use these predefined values
		 * once we're looking for the third number in the
		 * fibonacci sequence.
		 */
		int[] numbersInSequence = new int[number];
		int smaller = numbersInSequence[0] = 0;
		int bigger = numbersInSequence[1] = 1;
		// first and second number are predefined
		
		/*
		 * The third is the first to be determined through
		 * the sum. We want to keep printing until we get
		 * the 25th of the sequence. We use indexes 2 through
		 * length - 1 since array index starts at 0.
		 */
		for (int i = 2; i < number; i++) {
			int sum = smaller + bigger;
			numbersInSequence[i] = sum;
			/*
			 * Following the rules of fibbonacci,
			 * the bigger becomes the smaller and the
			 * sum becomes the bigger
			 */
			smaller = bigger;
			bigger = sum;
		}
		return numbersInSequence;
	}
}
