package com.revature;

import static com.revature.Question4.factorial;
import static org.junit.Assert.*;

import org.junit.Test;

public class Question4Test {

	@Test
	public void testFactorial() {
		assertEquals("Factorial Test 1",
				factorial(12), 479001600);
		assertEquals("Factorial Test 2",
				factorial(8), 40320);
		assertEquals("Factorial Test 3",
				factorial(6), 720);
		assertEquals("Factorial Test 4",
				factorial(5), 120);
		assertEquals("Factorial Test 5",
				factorial(0), 1);
		System.out.println("Question 4 test cases passed!");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFactorialForIllegalArgumentException() {
		factorial(-1);
		factorial(-15);
	}
}
