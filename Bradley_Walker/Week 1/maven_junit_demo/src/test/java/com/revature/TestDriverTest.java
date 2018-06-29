package com.revature;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestDriverTest {
	
	// assertEquals() tests that two values are the same
	// NOTEL with arrays and objects, the reference is checked, not the content or status
	@Test
	public void testMultiply() {
		TestDriver tester = new TestDriver();
		assertEquals("10 * 5 = 50", 50, tester.multiply(10, 5));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExceptionIsThrown() {
		TestDriver tester = new TestDriver();
		tester.multiply(1000, 10);
	}
}
