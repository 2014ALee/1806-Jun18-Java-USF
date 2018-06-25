package com.revature;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class BubbleSortTest {

	@Test
	public void testBubbleSort() {
		BubbleSort tester = new BubbleSort();
		int[] intArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		assertArrayEquals("Array should be printed in ascending order from left "
				+ "to right", intArray, BubbleSort.bubbleSort(intArray));
	}

}
