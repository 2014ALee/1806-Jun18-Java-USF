package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q13Test {

	@Test
	public void testPrintToConsole() {
		String str = "o\n10\n101\n1010";
		assertEquals("", str, printToConsole());
	}

}
