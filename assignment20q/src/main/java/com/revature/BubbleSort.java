package com.revature;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] bubbleArray = new int[] {1,0,5,6,3,2,3,7,9,8,4};
		BubbleSort bubbleSort = new BubbleSort();
		bubbleArray = bubbleSort.sortArray(bubbleArray);
		System.out.println(Arrays.toString(bubbleArray));
	}
	public int[] sortArray(int[] a) {
		for(int i = 0; i < a.length - 1; i++) {
			for(int j = 0; j < a.length -1 - i; j++) {
				if(j + 1 < a.length) {
					if(a[j] > a[j+1]) {
						int k = a[j];
						a[j] = a[j+1];
						a[j + 1] = k;
					}
				}
			}
		}
		return a;
	}
}
