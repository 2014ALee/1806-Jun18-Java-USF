package com.revature;

import static com.revature.Question2.generateFibonacciSeqence;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Question2Test {

	@Test
	public void testGenerateFibonacciSequence() {
		assertEquals("The first fibonacci number is 0", Arrays.equals(
				generateFibonacciSeqence(1),
				new int[] {0}), true);
		assertEquals("The first two numbers in a Fibonacci sequence are 0 and 1", 
				Arrays.equals(generateFibonacciSeqence(2),
				new int[] {0, 1}), true);
		assertEquals("When we ask the method to generate 4 sequence numbers, "
				+ "the result should be [0, 1, 1]",
				Arrays.equals(generateFibonacciSeqence(3),
				new int[] {0, 1, 1}), true);
		assertEquals("When we ask the method to generate 10 sequence numbers, "
				+ "the result should be [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]",
				Arrays.equals(generateFibonacciSeqence(10),
				new int[] {0, 1, 1, 2, 3, 5, 8, 13, 21, 34}), true);
		System.out.println("Question 2 Test cases passed.");
		assertEquals("When we ask the method to generate 25 sequence numbers, "
				+ "the result should be [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, "
				+ "55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, "
				+ "10946, 17711, 28657, 46368]",
				Arrays.equals(generateFibonacciSeqence(10),
				new int[] {0, 1, 1, 2, 3, 5, 8, 13, 21, 34,
						55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765,
						10946, 17711, 28657, 46368}), true);
	}

}