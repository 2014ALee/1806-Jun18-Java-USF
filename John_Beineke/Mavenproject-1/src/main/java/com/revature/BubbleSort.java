package com.revature;
public class BubbleSort {

	public static void main(String[] args) {

		// Declare array
		int[] intArray = new int[] {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};

		bubbleSort(intArray);
		
		// print sorted array using for loop
		System.out.print("The sorted array: " );
		for (int i = 0; i<intArray.length; i++) {
			System.out.print(intArray[i]);
		}
	}
	
	// Create bubble sort method 
	public static int[] bubbleSort(int[] intArray) {
		int temp;
		// There will be 9 traversals of the array
		for(int i = 0; i < intArray.length; i++) {
//			use these indices to compare 
			for (int j = 0; j < intArray.length - 1; j++) {
				// Check to see if the integer on the right is smaller. If it is,
				// swap these two integers
				if (intArray[j] > intArray[j+1]) {
					temp = intArray[j];
					intArray[j] = intArray[j+1];
					intArray[j+1] = temp;
				}
			}
		}
		
		return intArray;
	}
		
	

}
