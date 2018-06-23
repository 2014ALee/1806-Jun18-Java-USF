package com.revature;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestDriverTest {
	
	//checks if two values are the same
	//NOTE: for arrays and objects the reference is checked, not the contents and states
	
	@Test
	public void testMultiply() {
		TestDriver tester = new TestDriver();
		assertEquals("10 * 5 must equal 50", 50, tester.multiply(10, 5));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionIsThrown() {
		TestDriver tester = new TestDriver();
		tester.multiply(1000, 5);
	}
}
