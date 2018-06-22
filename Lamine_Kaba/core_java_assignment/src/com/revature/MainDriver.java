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
		
	}

}
