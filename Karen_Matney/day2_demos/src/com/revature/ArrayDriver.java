package com.revature;

public class ArrayDriver {
	public static void main(String[] args) {
		int myIntArray[];
		int[] myOtherIntArray;

		// instantiate arrays
		myIntArray = new int[5];
		myOtherIntArray = new int[] {1, 2, 3, 4, 5, 6};

		// array .....ADD later
		char[] myCharArray = {};

		myIntArray[0] = 10;
		System.out.println(myIntArray[0]);

		// Following causes out of bounds error because myIntArray[5] doesn't exist
		// myIntArray[5] = 10;
		// System.out.println(myIntArray[5]);
		// NOTE: can't increase(?) the array like in C++

		for(int i = 0; i < myIntArray.length; i++) {
			System.out.println(myIntArray[i]);
		}

		for(int i : myIntArray) { // Using Object or Integer instead of int will cause autoboxing
			System.out.println(i);
		}

		String[] names = new String[3];
		names[0] = "Wezley";
		names[1] = "Andrew";
		names[2] = "Simonisa";

		for(String name : names) {
			System.out.println(name);
		}

		// muti-dimensional arrays
		// int[][] my2dArray = new int[3][3];
		int[][] my2dArray = {{1,2,3}, {4,5,6}, {7,8,9}}; // with this method, can have different "lengths" (where the second is the length)

		int value = my2dArray[1][2];
		System.out.println(value);

		System.out.println(my2dArray[1]);
		for(int i = 0; i < my2dArray.length; i++) {
			for(int j = 0; j < my2dArray[i].length; j++) {
				System.out.println(my2dArray[i][j]);
			}
		}

		for(int[] intArray : my2dArray) {
			for(int number : intArray) {
				System.out.println(number);
			}
		}
	}
	// public // COPY INFO LATER
}
