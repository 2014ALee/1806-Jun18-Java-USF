package com.revature;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestDriverTest {
	// assertEquals() tests that two values are the same.
	// NOTE: with arrays/objects the reference is checked not the content or states
	@Test
	public void testMultiply() {
		TestDriver tester = new TestDriver();
		assertEquals("10 * 5 must equal 50", 50, tester.multiply(10, 5));
	}
	
	@Test
	public void fakeTest() {
		return;
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionIsThrown() {
		TestDriver tester = new TestDriver();
		tester.multiply(1000, 5);
	}
}
