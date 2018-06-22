package com.revature;

import java.util.ArrayList;

public class Question19 {
	public static void main(String[] args) {
		// The ArrayList for this problem for us to store numbers.
		ArrayList<Integer> ourArrayList = new ArrayList<Integer>();
		
		// The number for us to insert into the aray.
		int num = 0;
		// Inserting numbers 1 through 10 with indexes 0 through 9.
		while (num < 10) {
			ourArrayList.add(num, ++num);
		}
		// Storing the sums.
		int oddSum = 0;
		int evenSum = 0;
		
		/*
		 * Adding a value to a sum, even sum if even,
		 * odd sum if odd.
		 */
		for (int val : ourArrayList) {
			if (val % 2 == 0) {
				evenSum += val;
			}
			else {
				oddSum += val;
			}
		}
		System.out.println("Odd Sum: " + oddSum);
		System.out.println("Even Sum: " + evenSum);
		/*
		 * Removing primes
		 */
		for (int i = 0; i < ourArrayList.size(); i++) {
			if (isPrime(ourArrayList.get(i))) {
				ourArrayList.remove(i);
				i--;
			}
		}
		System.out.println("ArrayList without primes is: "
				+ ourArrayList);
	}
	/*
	 * Testing if number is prime.
	 * We're only using this function here.
	 */
	private static boolean isPrime(int input) {
		/* 1 is technically not prime based
		 * on mathematical definition.
		 */
		if (input == 1) {
			return false;
		}
		
		/*
		 * If number has any divisor k such that
		 * 2 >= k >= sqrt(number), number is not prime.
		 */
		for (int i = 2; i * i <= input; i++) {
			if (input % i == 0) {
				return false;
			}
		}
		return true;
	}
}