package com.revature;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Question1Test {

	@Test
	public void bubbleSortArrayTest() {
		int[] testArray = {3,6,5,1};
		int[] sortedArray = {1,3,5,6};
		assertArrayEquals(sortedArray, Question1.bubbleSortArray(testArray));
	}
}
