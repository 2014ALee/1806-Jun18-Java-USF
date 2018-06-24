package com.revature;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class QuestionOneDriverTest {

	@Test
	public void testBubbleSort() {
		
		//create arrays to test the bubbleSort() method
		int[] array1 = new int[] {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		int[] array2 = new int[] {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};

		//compare the sorted array with my bubbleSort method
		assertArrayEquals("The bubbleSort() method doesn't properly sort the array", array1, QuestionOneDriver.bubbleSort(array2));
	}

}
