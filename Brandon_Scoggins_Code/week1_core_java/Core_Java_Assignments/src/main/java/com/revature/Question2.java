package com.revature;
// Fibonacci sequence
public class Question2 {

	public static void main(String[] args) {
		int[] fibonacciArray = {};													// initialize an empty integer array to hold fibonacci numbers
		
		// ask user for number of fibonacci numbers?
		for (int i = 0; i < 25; i++) {												// used a for loop to calculate fibonacci numbers but could have used recursion
			fibonacciArray = nextFibonacciNum(fibonacciArray);						// reassigns fibonacci array to a new int[] that includes 1 additional fibonacci number
//			printIntArray(fibonacciArray);											// print int array for testing purposes
		}
		printIntArray(fibonacciArray);
	}
	//use recursion?
	public static int[] nextFibonacciNum(int[] numArr){								// method to calculate the next fibonacci number for a fibonacci array. Returns a fibonacci array from 0 to the newest number
		int [] newNumArr = new int[numArr.length + 1];								// creates an array that is one index larger than the array this method was passed
		
		for(int i = 0; i < numArr.length; i++)										// copies the array that was passed into the new array
			newNumArr[i] = numArr[i];
		
		if(newNumArr.length == 1)													// some logic to assign the first two fibonacci numbers if they havent already been added
			newNumArr[0] = 0;
		else if(newNumArr.length == 2)
			newNumArr[1] = 1;
		else if(newNumArr.length > 2) 												// if at least two numbers exist in the fibonnaci array, the next fibonacci number is calculated and added as the last entry in the array
			newNumArr[newNumArr.length - 1] = newNumArr[newNumArr.length - 2] + newNumArr[newNumArr.length - 3];
		
		return newNumArr;															// returns the updated fibonacci array
	}
	// Method to print one dimensional int arrays
		public static void printIntArray(int[] arr) {								// uses a for each loop to print all values in an int[]
			// for-each loop
			for(int number : arr)
				System.out.print(number + " ");
			System.out.println();
		}
}
