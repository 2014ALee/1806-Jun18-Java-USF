package com.revature;

public class ArrayDriver {
	
	public static void main(String[] args) {
		
		int myIntArray[]; //or
		int[] myOtherArray;
		
		
		//Instantiate
		myIntArray = new int[5];
		myOtherArray = new int[] {1, 2, 3, 4, 5, 6};
		
		//Any combination for declaration and instantiation works.
		
		System.out.println(myIntArray[0]);
		
		System.out.println("-----------------------------");
		
		for (int i = 0; i < myIntArray.length; i++) {
			System.out.println(myIntArray[i]);
		}
		
		System.out.println("-----------------------------");
		
		for (Integer num : myIntArray) {
			System.out.println(num);
		}
		
		String[] names = new String[3];
		names[0] = "Wezley";
		names[1] = "Andrew";
		names[2] = "Simonisa";
		
		for (String name : names) {
			System.out.println(name);
		}
		
		System.out.println("-----------------------------");
		
		int[][] my2dArray = new int[3][3];
		
		int[][] myOther2dArray = { {1,2,3}, {4, 5, 6}, {7, 8, 9} };
		
		int value = myOther2dArray[1][2];
		
		System.out.println(value);
		
		//Nested for each loop for multidimensional arrays
		
//		public static void workWithArray(int[] arr) {
//			for (Integer numb : arr) {
//				System.out.println(numb);
//			}
//		}
	}

}
