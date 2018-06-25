/*
 * Karen Matney
 * June 21, 2018
 * Revature Training: Core Java Assignment
 * Q1BubbleSort.java
 * Code for Q1 of Core Java Assignment. Takes a pre-specified array and sorts it using bubble sort.
 */
package com.revature;

public class Q1BubbleSort {
	public static void main(String[] args) {
		int[] sorted;
		int[] intToSort = { 1,0,5,6,3,2,3,7,9,8,4 };	// Array to sort

		sorted = sortArray(intToSort);

		// Sorted array to console
		System.out.print("Sorted Array: ");
		System.out.print(sorted[0]);
		for(int i = 1; i < sorted.length; i++) {
			System.out.print(", ");
			System.out.print(sorted[i]);
		}
	}

	static int[] sortArray(int[] intToSort) {
		int current;									// Holder for current index of sorting array
		int next;										// Holder for the next index of sorting array

		boolean swapped = false;						// To see if the array needed any values swapped

		// Original Array to console
		System.out.print("Original String: ");
		System.out.print(intToSort[0]);
		for(int i = 1; i < intToSort.length; i++) {
			System.out.print(", ");
			System.out.print(intToSort[i]);
		}
		System.out.print("\n");

		// Compare current and next values in array, swapping when necessary, until values are no longer swapped
		do {
			swapped = false;

			// Next to last element and last element is last comparison
			for(int i = 0; i < (intToSort.length - 1); i++) { 
				// could've used one to hold for a swap, but this seems more readable
				current = intToSort[i];
				next = intToSort[i+1];

				/*
				 * This is the only condition that would require a (necessary) swap.
				 * if(current > next || current == next) would result in an infinite loop,
				 * unless '&& current != next' is added to if(swapped == false). 
				 */
				if(current > next) {
					intToSort[i] = next;
					intToSort[i+1] = current;

					// Not necessary, but keeps from an assignment every time this block executes.
					if(swapped == false) swapped = true;
				}
			}
		}while(swapped);

		return intToSort;
	}
}
