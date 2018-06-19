package com.revature;

public class ArrayDriver {
	
	
	public static void main(String[] args) {
		int [] myIntArray;
		
		myIntArray = new int[10];
		
		int[] myOtherIntArray;
		
		myOtherIntArray = new int[] {1,2,3};
		
		myIntArray[0] = 10;
		System.out.println(myIntArray[0]);
		
		//best for use with data structures
		for(int number: myIntArray) {
			System.out.println(number);
		}
		
		
		String[] names = new String[3];
		names[0] = "Wezley";
		names[1] = "Andrew";
		names[2] = "Tom";
		
		for(String name : names) {
			System.out.println(name);
		}
		
		
		int [][] my2DArray = new int[3][3];
		//row, column
		
		
		
		
		
		
		//for(int[] number: my2DArray) {
			//System.out.println(number);
		//}
		
	}

}
