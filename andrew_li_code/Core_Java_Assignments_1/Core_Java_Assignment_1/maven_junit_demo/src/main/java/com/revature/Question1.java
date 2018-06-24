package com.revature;

public class Question1 {
	
	public static void main(String[] args) {
		int[] inputArray = new int[] {1,0,5,6,3,2,3,7,9,8,4};
		printArray(inputArray);
		sort(inputArray);
		printArray(inputArray);
	}
	
	public static void sort(int[] array) {
		final int ROUNDS = array.length - 1;
		int pairsToCheck = array.length - 1;
		/*
		 * Repeat this process until the second smallest
		 * number is moved to the second spot, the smallest
		 * number would have nowhere to be (other than the
		 * first slot). Hence, the number of rounds is the
		 * length - 1.
		 */
		for (int i = 0; i < ROUNDS; i++) {
			/*
			 * In each passing, do the swap for every
			 * pair from left to right. When we get to
			 * the maximum value in the array, it will
			 * certainly be swapped, and be checked
			 * again (leading it to eventually be moved
			 * to the end)
			 */
			for (int j = 0; j < pairsToCheck; j++) {
				/*
				 * Swap the neighboring pair if
				 * left greater than right.
				 */
				if (array[j] > array[j + 1]) {
					int smaller = array[j + 1];
					array[j + 1] = array[j];
					array[j] = smaller;
				}
			}
			/*
			 * Since we know that the maximum values
			 * have been moved to the end, we can
			 * shrink the number of pairs to check.
			 */
			pairsToCheck--;
		}
	}
	
	// Just to neatly show the array.
	private static void printArray(int[] inputArray) {
		System.out.print("[");
		if (inputArray.length > 0) {
			System.out.print(inputArray[0]);
		}
		for (int i = 1; i < inputArray.length; i++) {
			System.out.print(", " + inputArray[i]);
		}
		System.out.print("]");
		System.out.println("");
	}
}
