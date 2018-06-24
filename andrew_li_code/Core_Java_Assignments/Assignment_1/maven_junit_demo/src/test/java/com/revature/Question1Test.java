package com.revature;

import static com.revature.Question1.sort;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Question1Test {

	@Test
	public void testSort() {
		int[] array1 = new int[] { 65, 23, 219, 453, 64 };
		sort(array1);
		assertEquals("Comparing an array against its sorted version",
				Arrays.equals(array1, new int[] {
						23, 64, 65, 219, 453}), true);
		
		int[] array2 = new int[] { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		sort(array2);
		assertEquals("Comparing another array against its sorted version",
				Arrays.equals(array2, new int[] {
						0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9}), true);
		
		int[] array3 = new int[] { 4, 7, 2, 9, 1, 14, 12};
		sort(array3);
		assertEquals("Comparing one more array against its sorted version",
				Arrays.equals(array3, new int[] {
						1, 2, 4, 7, 9, 12, 14 }), true);
		
		System.out.println("Question 1 test cases passed!");
	}

}
