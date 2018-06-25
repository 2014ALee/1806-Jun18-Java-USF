package com.revature;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class reverseStringTest {

	@Test
	public void testStringReversalHello() {
		reverseString tester = new reverseString();
		String str1 = "Hello";
		assertEquals("Should return the string backwards.", "olleH", tester.StringReversal(str1) );
	}
	
	@Test
	public void testStringReversalString() {
		reverseString tester = new reverseString();
		String str1 = "Hello, my name is John";
		assertEquals("Should return the string backwards.", "nhoJ si eman ym ,olleH", tester.StringReversal(str1) );
	}

}
