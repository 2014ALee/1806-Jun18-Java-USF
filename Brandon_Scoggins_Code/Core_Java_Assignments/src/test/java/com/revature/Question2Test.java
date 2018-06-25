package com.revature;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Question2Test {

	@Test
	public void fibonacciNumTest1() {
		int[] inArray = {0, 1};
		int[] outArray = {0, 1, 1};
		assertArrayEquals(outArray, Question2.nextFibonacciNum(inArray));
	}
	
	@Test
	public void fibonacciNumTest2() {
		int[] inArray = {0, 1, 1, 2, 3, 5, 8, 13};
		int[] outArray = {0, 1, 1, 2, 3, 5, 8, 13, 21};
		assertArrayEquals(outArray, Question2.nextFibonacciNum(inArray));
		
	}
}
