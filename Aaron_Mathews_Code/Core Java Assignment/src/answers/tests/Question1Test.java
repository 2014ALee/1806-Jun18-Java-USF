package answers.tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import answers.Question1;

class Question1Test {

	@Test
	public void testBubbleSort() {
		int[] testArray = {1, 4, 5, 2, 3};
		int[] sortedArray = {1, 2, 3, 4, 5};
		
		assertEquals("Array {1, 4, 5, 2, 3} is sorted to {1, 2, 3, 4, 5}", Arrays.toString(sortedArray), Arrays.toString(Question1.bubbleSort(testArray)));
	}

}
