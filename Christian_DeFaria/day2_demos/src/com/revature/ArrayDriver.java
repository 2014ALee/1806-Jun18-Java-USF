package com.revature;

public class ArrayDriver {
	
	public static void main(String[] args) {
		//array declarations
		int myIntArray[];	//this is a valid array declaration
		int[] myOtherIntArray;	//this is a valid array declaration
		
		//array literals by themselves
		char[] myCharArray = {'a', 'b', 'c'};
		
		//instantiate arrays
		myIntArray = new int[5];
		myOtherIntArray = new int[] {1, 2, 3, 4, 5, 6};
		
		//myIntArray[5] = 10;
		//System.out.println(myIntArray[5]);
		
		for(int i=0; i<myIntArray.length; i++) {
			System.out.println(myIntArray[i]);
		}
		System.out.println("--------------");
		
		for(int number : myIntArray) {
			System.out.println(number);
		}
		System.out.println("--------------");
		
		String[] names = new String[3];
		names[0] = "Wezley";
		names[1] = "Andrew";
		names[2] = "Simonisa";
		
		for(String name : names) {
			System.out.println(name);
		}
		System.out.println("--------------");
		
		//multi-dimensional arrays
		//int[][] my2dArray = new int[3][3];
		int[][] my2dArray = {{1,2,3}, {4,5,6}, {7,8,9}};
		int value = my2dArray[1][2];
		
		System.out.println(my2dArray[1]);
		for(int i = 0; i< my2dArray.length; i++) {
			for(int j = 0; j < my2dArray[i].length; j++) {
				System.out.println(my2dArray[i][j]);
			}
		}
		System.out.println("--------------");
		
	}
	
}
