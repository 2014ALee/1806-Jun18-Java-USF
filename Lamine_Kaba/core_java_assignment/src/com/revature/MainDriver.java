package com.revature;

public class MainDriver {

	public static void main(String[] args) {
		
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		
		BubbleSortArray mySortedArray = new BubbleSortArray();
		
		mySortedArray.bubbleSortArray(array);
		
		for(int i = 0; i < array.length; i++) {
			
			System.out.print(array[i]);
			System.out.print(" ,");
		}
		
	}

}
