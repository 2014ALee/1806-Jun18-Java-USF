package com.revature;

public class BubbleSortArray {

	public void bubbleSortArray(int[] array) {
		
		int indexCount = array.length;
		int temp = 0;
		
		// Get the element of the array
		
		for(int i = 0; i < indexCount; i++) {
			
			// Compare and sort by smallest 
			
			for(int j = 1; j < (indexCount-i); j++) {
				
				if(array[j-1] > array[j]) {
					temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
}
