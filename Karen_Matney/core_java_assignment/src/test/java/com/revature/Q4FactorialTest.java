package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q4FactorialTest {

	@Test
	public void negativeFactorial() { // returns -1 since that's not a possible result
		assertEquals("returns -1",-1,Q4Factorial.factorialCalc(-5));
	}
	
	@Test
	public void tenFactorial() { // returns -1 since that's not a possible result
		assertEquals("returns factorial of ten",3628800,Q4Factorial.factorialCalc(10));
	}

}
