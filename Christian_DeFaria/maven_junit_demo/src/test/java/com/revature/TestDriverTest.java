package com.revature;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revatue.TestDriver;

public class TestDriverTest {
	
	@Test
	public void testMultiply( ) {
		TestDriver tester = new TestDriver();
		assertEquals("10*5 must equal 50", 50, tester.multiply(10, 5));
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
