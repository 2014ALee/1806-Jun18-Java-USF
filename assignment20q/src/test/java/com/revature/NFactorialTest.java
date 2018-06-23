package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class NFactorialTest {

	@Test
	public void testNFactFinder() {
		int i = 5;
		assertTrue("Exspected 120", 120 == NFactorial.nFactFinder(i));
	}

}
