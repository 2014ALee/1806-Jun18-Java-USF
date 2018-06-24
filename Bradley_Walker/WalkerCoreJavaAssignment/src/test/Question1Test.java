package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import answers.Question1;

public class Question1Test {
	
	@Test
	public void testBubbleSort() {
		int[] unordered = {4, 7, 1, 8, 5, 4, 5, 6, 7, 8, 7, 9, 2, 0, 0, 1, 7, 2, 1, 1, 3, 4, 0};
		int[] ordered = {0, 0, 0, 1, 1, 1, 1, 2, 2, 3, 4, 4, 4, 5, 5, 6, 7, 7, 7, 7, 8, 8, 9};
		assertEquals("Testing bubble sort", true, Arrays.equals(ordered, Question1.bubbleSort(unordered)));
	}

}
