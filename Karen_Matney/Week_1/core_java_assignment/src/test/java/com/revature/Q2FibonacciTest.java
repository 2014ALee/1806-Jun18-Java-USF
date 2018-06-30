package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q2FibonacciTest {

	@Test
	public void first8Fibonacci() {
		Integer[] first8Test = new Integer[] { 0,1,1,2,3,5,8,13 };
		
		assertArrayEquals("Successful, got first 8", first8Test,Q2Fibonacci.fibonacci(8));
	}

}
