package com.revature;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class nFactorialTest {

	@Test
	public void testComputeFactorial() {
		assertEquals("Should return 120", 120, nFactorial.computeFactorial(5));
	}

}
