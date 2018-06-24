package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDriverTest {

	//assertEqueals tests that 2 values are the same
	//Note: reference is checked for objects. Use assertSame().
	@Test
	public void testMultiply() {
		TestDriver tester = new TestDriver();
		assertEquals("10 * 5 = 50",  50, tester.multiply(10, 5));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionIsThrown() {
		TestDriver tester = new TestDriver();
		tester.multiply(1000, 5);
	}
}
