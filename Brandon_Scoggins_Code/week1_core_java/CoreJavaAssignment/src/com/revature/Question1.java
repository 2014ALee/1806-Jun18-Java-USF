package com.revature;
// Bubble sort int array
public class Question1 {

	public static void main(String[] args) {
		// Initialize int array 
		int[] unSortedArray = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		// Print original array
		printIntArray(unSortedArray);		
		// Sort array using bubble sort
		bubbleSortArray(unSortedArray);			// Why do I not need to reassign unSortedArray?  pass by value
		// Print sorted array
		printIntArray(unSortedArray);		
	}
	// Method to bubble sort an int array
	public static int[] bubbleSortArray(int[] unSortedArray){
		// Initialize an int variable to hold array values that need to be switched
		int temp = 0;
		// Nested for loop
		// Outside for loop tells the inside loop how many times/indexes to check
		for(int j = unSortedArray.length; j > 0; j--) {
			// Inside for loop compares adjacent index values from 0 to j
			for(int i = 0; i < j - 1; i++) {
				// If statement to compare index values
				if(unSortedArray[i] > unSortedArray[i + 1]) {
					// If adjacent index values need to be switched, the lower index value is stored as temp
					temp = unSortedArray[i];
					// The lower index takes on the value of the higher index
					unSortedArray[i] = unSortedArray[i + 1];
					// The higher index takes the temp value
					unSortedArray[i + 1] = temp;
				}
			}
		}
		// The now sorted int array is returned
		return unSortedArray;
	}
	// Method to print one dimensional int arrays
	public static void printIntArray(int[] arr) {
		// for-each loop
		for(int number : arr)
			System.out.print(number + " ");
		System.out.println();
	}
}
