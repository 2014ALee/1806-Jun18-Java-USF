package answers;

import java.util.Arrays;

public class Question1 {

	public static int[] initialArray = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};

	public static void main(String[] args) {

		System.out.println(Arrays.toString(initialArray));
		int[] sortedArray = bubbleSort(initialArray);
		System.out.println(Arrays.toString(sortedArray));

	}

	public static int[] bubbleSort(int[] arr) {
		int[] sortingArray = new int[arr.length];
		boolean swapped = false;
		boolean firstIteration = true;
		if (swapped || firstIteration) {
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i + 1] < arr[i]) {
					sortingArray[i] = arr[i + 1];
					sortingArray[i + 1] = arr[i];
					firstIteration = false;
					swapped = true;
				} else {
					swapped = false;
				}
			}
		}
		return sortingArray;
	}

}
