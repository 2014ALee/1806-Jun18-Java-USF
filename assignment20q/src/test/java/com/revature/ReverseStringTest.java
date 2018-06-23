package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseStringTest {

	@Test
	public void testReverseStr() {
		ReverseString rev = new ReverseString();
		assertTrue("They are not equal","fire".equals(rev.reverseStr("erif")));
	}
}
