package com.revature;

public class MainDriver {

	public static void main(String[] args) {
		
		/*
		 * Q1 Sorting an array using bubble sort
		 */
		// Original array
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		
		// Instantiate BubbleSortArray object
		
		BubbleSortArray mySortedArray = new BubbleSortArray();
		
		// Call sorting Method on the object
		
		mySortedArray.bubbleSortArray(array);
		
		// Print the sorted values
		for(int i = 0; i < array.length; i++) {
			
			System.out.print(array[i]);
			System.out.print(" ,");
		}
		
		System.out.println("\n-------------------------------");
		
		/*
		 * Q2  FibonacciNumbers
		 */
		
		FibonacciNumbers myFibonacci = new FibonacciNumbers();
		
		myFibonacci.display();
		
		System.out.println("\n-------------------------------");
		
		/*
		 * Q3 Reverse String
		 */
		
		ReverseString myReverse = new ReverseString();
		
		myReverse.reverseString();
		
		System.out.println("\n-------------------------------");
		
		/*
		 * Q4 N factorial
		 */
		
		Nfactorial.factorial();		
	}

}
















