package com.revature;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.revature.BubbleSort;


public class BubbleSortTest {

	@Test
	public void testSortArray() {
		int[] array1 = new int[] {1,0,5,6,3,2,3,7,9,8,4};
		int[] array2 = new int[] {1,0,5,6,3,2,3,7,9,8,4};
		BubbleSort bubbleSort = new BubbleSort();
		Arrays.sort(array2);
		bubbleSort.sortArray(array1);
		Assert.assertTrue("They are not equal",Arrays.toString(array2).equals(Arrays.toString(array1)));
	}

}
