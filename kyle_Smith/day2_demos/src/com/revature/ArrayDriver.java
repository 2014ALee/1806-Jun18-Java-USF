package com.revature;

public class ArrayDriver {

	public static void main(String[] args) {
		int myIntArray[];
		int[] myOtherIntArray;
		
		//instantiate arrays
		myIntArray = new int[5];
		myOtherIntArray = new int[] {1,2,3,4,5,6};
		
		myIntArray[0] = 10;
		System.out.println(myIntArray[0]);
		
		for (int number: myIntArray) {
			System.out.println(number);
		}
	
		String[] names = new String[3];
		names[0] = "wezley";
		names[1] = "Andrew";
		names[2] = "simonisa";
		
		for(String name : names) {
			System.out.println(name);
		}
	
		//multi-dimensional arrays!
		int[][] my2dArray = {{1,2,3},{4,5,6},{7,8,9}};
		
		for (int i = 0; i < my2dArray.length; i++) {
			for(int j = 0; j < my2dArray[i].length; j++) {
				System.out.println(my2dArray[i][j]);
			}
		}
	
	
	}
	
}
