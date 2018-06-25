package com.revature;

public class FibonacciSequence {

	public static void main(String[] args) {

		// Declare array to hold fibonacci numbers
		int[] fibonacciArray = new int[25];
		// first two numbers in fibonacci are 0 and 1
		fibonacciArray[0] = 1;
		fibonacciArray[1] = 2;
		
		computeFibonacci(fibonacciArray);
		
		System.out.println("The first 25 Fibonacci Numbers are: ");
		for(int i =0; i < fibonacciArray.length; i++) {
			System.out.print(fibonacciArray[i] + " ");
		}
		
	}
	
	public static int[] computeFibonacci(int[] fibonacciArray) {
		// compute next fibonacci number by adding the two previous numbers
				for (int i = 2; i < fibonacciArray.length; i++) {
					fibonacciArray[i] = fibonacciArray[i-1] + fibonacciArray[i-2];		
				}
				return fibonacciArray;
	}

}
