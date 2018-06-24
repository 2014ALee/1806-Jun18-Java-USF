package com.revature;

import java.util.ArrayList;

public class Question9 {
	public static void main(String[] args) {
		ArrayList<Integer> firstHundredNumbers = new ArrayList<Integer>();
		// 1 is a special number since it has the features
		// of other prime numbers but is not a prime itself
		/*
		 * Therefore, we add it separately but deal with
		 * it in a different manner from the non-primes.
		 */
		firstHundredNumbers.add(1);
		
		/*
		 * Going from 2 through 100, we add it
		 * to the ArrayList, and print if it's
		 * prime.
		 */
		for (int i = 2; i <= 100; i++) {
			firstHundredNumbers.add(i);
			
			/*
			 * To check if a number is prime,
			 * Check if the number has any factors
			 * between two and the square root (floored)
			 * If so, not a prime. If not, it is a prime
			 * and should be printed.
			 */
			boolean isPrime = true;
			for (int j = 2; j * j <= i; j++) {
				if (i % j == 0) {
					isPrime = false;
					j = i;
				}
			}
			if (isPrime) {
				System.out.println(i);
			}
		}
	}
}
