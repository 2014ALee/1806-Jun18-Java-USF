package com.revature;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestDriverTest {
	
	//
	@Test //test annotation
	public void testMultiply() {
		TestDriver tester = new TestDriver();
		
		assertEquals( "10 * 5 must equal 50", 50, tester.multiply(10, 5));
	}
	
	//testing if the right argument is thrown
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionIsThrown() {
		TestDriver tester = new TestDriver();
		tester.multiply(1000, 5);
	}
}
