package com.revature;

public class Question4 {
	public static void main(String[] args) {
		int x = 10;
		System.out.println(factorial(x));
	}
	public static int factorial(int number) {
		int product = 1;
		// Factorial is 1 * 2 * ... * number.
		// This for loop should suffice.
		for (int i = 2; i <= number; i++) {
			product *= i;
		}
		return product;
	}
}
