package com.revature.model;

public class BubbleSort {

	public void Sort(int[] myIntArray) {
		
		for(int num : myIntArray) {
			for(int x = 0; x < myIntArray.length - 1; x++) {

				if (myIntArray[x] > myIntArray[x+1]) {

					int holder = myIntArray[x + 1];
					myIntArray[x + 1] = myIntArray[x];
					myIntArray[x] = holder;
				}
			}
		}

		for(int num : myIntArray) {
			System.out.print(num);
		}
		
	}

}
