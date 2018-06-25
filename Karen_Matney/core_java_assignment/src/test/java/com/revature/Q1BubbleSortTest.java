package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q1BubbleSortTest {

	@Test
	public void sortsArray() {
		assertArrayEquals("is sorted",new int[] {0,1,2,3,3,4,5,6,7,8,9},Q1BubbleSort.sortArray(new int[] { 1,0,5,6,3,2,3,7,9,8,4 }));
	}

}
