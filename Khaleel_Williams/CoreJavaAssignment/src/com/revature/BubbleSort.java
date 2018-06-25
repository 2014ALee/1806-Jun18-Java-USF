package com.revature;

public class BubbleSort {

	public static void main(String[] args) {
		int [] intArray = {8,4,2,8,9,1,4,3};
		intArray = Sort(intArray);
		
		for(int num : intArray) {
			System.out.print(num);
		}
		
	}
	public static int[] Sort(int[] myIntArray) {
		
		for(int num : myIntArray) {
			for(int x = 0; x < myIntArray.length - 1; x++) {

				if (myIntArray[x] > myIntArray[x+1]) {

					int holder = myIntArray[x + 1];
					myIntArray[x + 1] = myIntArray[x];
					myIntArray[x] = holder;
				}
			}
		}

		return myIntArray;
	}

}
