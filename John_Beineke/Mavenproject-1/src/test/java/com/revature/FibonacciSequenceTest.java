package com.revature;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FibonacciSequenceTest {

	@Test
	public void test() {
		int[] array = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377,
				610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368};
	
		int[] fibArray = new int[25];
		fibArray[0] = 0;
		fibArray[1] = 1;
		assertEquals("Should return first 25 fibonacci numbers.", array,
				FibonacciSequence.computeFibonacci(fibArray));
	}

}
