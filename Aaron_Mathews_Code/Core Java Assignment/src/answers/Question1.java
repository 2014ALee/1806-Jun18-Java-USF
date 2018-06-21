package answers;

import java.util.Arrays;

public class Question1 {

	public static int[] initialArray = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};

	public static void main(String[] args) {

		//System.out.println(Arrays.toString(initialArray));
		int[] sortedArray = bubbleSort(initialArray);
		//System.out.println(Arrays.toString(sortedArray));

	}

	public static int[] bubbleSort(int[] arr) {
		boolean sorted = false;
		while (!sorted) {
			for (int i = 0; i < arr.length - 1; i++) {
				boolean swapped = false;		
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					swapped = true;
					System.out.println(Arrays.toString(arr));
					System.out.println(i);
				} else if ((i == arr.length - 1) && !swapped) {
					System.out.println("Array sorted");
					sorted = true;
				}
			}
		}
		return arr;
	}

}
