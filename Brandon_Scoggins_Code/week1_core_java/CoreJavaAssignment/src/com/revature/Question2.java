package com.revature;
// Fibonacci sequence
public class Question2 {

	public static void main(String[] args) {
		int[] fibonacciArray = {};
		
		// ask user for number of fibonacci numbers?
		System.out.println(fibonacciArray.length);
		// with for
		for (int i = 0; i < 25; i++) {
			fibonacciArray = nextFibonacciNum(fibonacciArray);
			printIntArray(fibonacciArray);
		}
		printIntArray(fibonacciArray);
		// with recursion
	}
	//use recursion?
	public static int[] nextFibonacciNum(int[] numArr){
		int [] newNumArr = new int[numArr.length + 1];
		
		for(int i = 0; i < numArr.length; i++)
			newNumArr[i] = numArr[i];
		
		if(newNumArr.length == 1)
			newNumArr[0] = 0;
		else if(newNumArr.length == 2)
			newNumArr[1] = 1;
		else if(newNumArr.length > 2) 
			newNumArr[newNumArr.length - 1] = newNumArr[newNumArr.length - 2] + newNumArr[newNumArr.length - 3];
		
		return newNumArr;
	}
	// Method to print one dimensional int arrays
		public static void printIntArray(int[] arr) {
			// for-each loop
			for(int number : arr)
				System.out.print(number + " ");
			System.out.println();
		}
}
