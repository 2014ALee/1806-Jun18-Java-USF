package com.revature;

public class Question6 {
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			int random = (int) (Math.random() * 10000);
			System.out.println(random + " is " + (isEven(random) ? "even" : "odd"));
		}
	}
	public static boolean isEven(int num) {
		// Integer division takes out remainder.
		int temp = num / 2;
		// Multiplication certainly doesn't recover remainder
		temp *= 2;
		/*
		 * If there was no remainder than subtraction should
		 * result in 0.
		 */
		temp -= num;
		return temp == 0;
	}

}
