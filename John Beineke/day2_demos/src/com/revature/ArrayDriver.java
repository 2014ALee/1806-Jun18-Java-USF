package com.revature;

public class ArrayDriver {

	public static void main(String[] args) {
		
		//Array declaration
		int myIntArray[];
		int[] myOtherIntArray; // These are both valid array declarations
		
		// instantiate arrays
		myIntArray = new int[5];
		myOtherIntArray = new int[] {1, 2, 3, 4, 5, 6};
		
		myIntArray[0] = 10;
		System.out.println(myIntArray[0]);
		
		// for each loop
		for ( int number : myIntArray) {
			System.out.println(number);
		}
		
		// multi dimensional array
		
		//int[][] my2dArray = new int[3][3];
		int[][] my2dArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		
		int value = my2dArray[1][2];
		//System.out.println(my2dArray[1]); Prints out memory reference of object
		
		for (int i = 0; i < my2dArray.length; i++) {
			for (int j = 0; j< my2dArray[i].length; j++) {
				System.out.println(my2dArray[i][j]);
			}
		}
	}
}
