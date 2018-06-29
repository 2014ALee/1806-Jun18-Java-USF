package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import answers.Question12;

public class Question12Test {
	
	@Test
	public void testGetEvens() {
		int[] testNums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] evenNums = {0, 2, 4, 6, 8, 10};
		assertEquals("Testing evens", true, Arrays.equals(evenNums, Question12.getEvens(testNums)));
	}

}
