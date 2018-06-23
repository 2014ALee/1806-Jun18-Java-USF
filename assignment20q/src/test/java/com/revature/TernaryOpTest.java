package com.revature;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TernaryOpTest {

	@Test
	public void testTernaryOp() {
		int int1 = 12;
		int int2 = 12;
		TernaryOp tern = new TernaryOp();
		assertTrue(tern.minValue(int1, int2) <= int1);
	}
}
