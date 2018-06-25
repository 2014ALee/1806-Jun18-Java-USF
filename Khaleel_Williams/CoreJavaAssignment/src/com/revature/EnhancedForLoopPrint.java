package com.revature;

public class EnhancedForLoopPrint {
	
	public static void main(String[] args) {
		EnhancedForLoop();
	}

	public static void EnhancedForLoop() {

		//create an array of integers with 100 empty slots
		int intArray[] = new int[100];

		//fills empty slots with integers from 1 - 100
		for (int i = 1 ; i < 101 ; i++) {

			intArray[i-1] = i;	
		}
		
		//enhanced for loop(for each loop) loops through the list
		for(int i : intArray) {
			
			// checks if number in the list is even
			if ((i % 2) == 0) {
				
				System.out.println(i);
				
			}else {}
		}
		
		

	}
}
