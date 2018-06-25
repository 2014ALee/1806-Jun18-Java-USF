package com.revature;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TernaryCompareTest {

	@Test
	public void testFindMin() {
		TernaryCompare tester = new TernaryCompare();
		assertEquals("Should return the smaller of two numbers.", 17, tester.findMin(17, 18));		
		assertEquals("Should return the smaller of two numbers.", 5, tester.findMin(62, 5));
	}
}
