package com.revature;

public class ArrayDriver {
	
	public static void main(String[] args) {
	
		//declare arrays 2 ways
		int[] myIntArray;
		int myOtherArray[];
		
		//instantiate arrays 2 ways
		myIntArray = new int[5]; //0 is the default value added for each spot in the array
		myOtherArray = new int[] {1, 2, 3, 4, 5};
		
		//throws out of bounds exception because theres only 5 spots, not 6 
		//System.out.println(myIntArray[5]);
		
		
		//The following 2 loops do the same thing
		for (int i = 0; i < myIntArray.length; i++) {
			System.out.println(myIntArray[i]);
		}
		
		System.out.println("-----------------");
		
		for (int number : myIntArray) {
			System.out.println(number);
		}
		
		
		//regular string array
		String[] names = new String[3];
		names[0] = "wezley";
		names[1] = "andrew";
		names[2] = "simonisa";
		
		//foreach
		for (String name : names) {
			System.out.println(name);
		}
		//multi-dimensional arrays: like an array of arrays
		//int[][] my2dArray = new int[3][3];
		int[][] my2dArray = { {1,2,3},{4,5,6},{7,8,9} };
		int value = my2dArray[1][2];
		
		System.out.println(value);//prints 6 because its the 2nd group and the 3rd spot
		System.out.println(my2dArray[1]); //shows the location of the array, not the values
		
		for (int i = 0; i < my2dArray.length; i++) {
			
			for (int j = 0; j < my2dArray[i].length; j++) {
				System.out.println(my2dArray[i][j]); //print all multi-dimentional array values
			}
		}
		
		//same with foreach
		for(int[] intArray : my2dArray) {
			for (int num : intArray) {
				System.out.println(num);
			}
		}
	}

}
