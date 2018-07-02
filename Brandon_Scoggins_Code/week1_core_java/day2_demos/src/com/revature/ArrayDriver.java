package com.revature;

public class ArrayDriver {

	public static void main(String[] args) {
		int myIntArray[]; 		//one syntax
		int[] myOtherIntArray;	//other syntax 			both are valid
		
		// instantiate arrays (two ways)
		myIntArray = new int[5];		// defaults entries to lowest positive value
		myOtherIntArray = new int[] {1, 2, 3, 4, 5, 6};
		
//		myIntArray[0] = 10;
//		System.out.println(myIntArray[0]);

		// throws ArrayIndexOutOfBoundsException
//		myIntArray[5] = 10;
//		System.out.println(myIntArray[5]);
		
		for(int i = 0; i < myIntArray.length; i++)
			System.out.println(myIntArray[i]);
		
		System.out.println("------------------------");
		
		// for each in a collection
		for(int number : myIntArray)
			System.out.println(number);
		
		
		String[] names = new String[3];
		names[0] = "Wezley";
		names[1] = "Andrew";
		names[2] = "Simonisa";

		System.out.println("------------------------");
		
		for(String name : names)
			System.out.println(name);		

		System.out.println("------------------------");
		
		// Multi-Dimensional arrays
		//int[][] my2dArray = new int[3][2];			// instantiate a 2d array with specific dimensions but default values
		int[][] my2dArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};		// instantiate with dimensions and specific values
		
		int value = my2dArray[1][2];
		System.out.println(value);
		System.out.println(my2dArray[1]);

		System.out.println("------------------------");
		
		for(int i = 0; i < my2dArray.length; i++) {
			for(int j = 0; j < my2dArray[i].length; j++) {
				System.out.print(my2dArray[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("------------------------");
		
		for(int[] intArray : my2dArray) {
			for(int number : intArray) {
				System.out.print(number + " ");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
	}
}
