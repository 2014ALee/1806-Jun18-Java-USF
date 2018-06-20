package com.revature;

public class ArrayDriver {

	public static void main(String[] args) {
		// initialized to all 0's
		int[] myIntArray = new int[5];
		int[] myOtherIntArray = {0, 1, 2};
		
		for(int i = 0; i < myIntArray.length; i++)
			myIntArray[i] = i+1;
		
		// Enhanced for loop a.k.a. foreach
		System.out.println("Enhanced For Loop");
		for(int i : myIntArray) 
			System.out.print(i + " ");
		System.out.println();
		
		// Multidimensional array
		System.out.println("\nMultidimensional Array");
		int[][] my2DArray = {{1,2,3},{4,5,6},{7,8,9}};
		for(int i = 0; i < my2DArray.length; i++) {
			for(int j = 0; j < my2DArray[i].length; j++)
				System.out.print(my2DArray[i][j] + " ");
			System.out.println();
		}
	}

}
