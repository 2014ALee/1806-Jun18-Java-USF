package com.revature;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestDriverTest {
	@Test
	public void testMultiply() {
		TestDriver tester = new TestDriver();
		assertEquals("tester.multiply(10, 50) = 500",
				tester.multiply(10, 50), 500);
	}
}
