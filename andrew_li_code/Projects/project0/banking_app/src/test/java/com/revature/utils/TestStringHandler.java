package com.revature.utils;

import static com.revature.utils.StringHandler.isAlphaNumeric;
import static com.revature.utils.StringHandler.threeDot;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestStringHandler {

	@Test
	public void testThreeDot() {
		assertEquals("Two decimals is appropriate", 
				threeDot("2103.12"), false);
		assertEquals("Three decimals is not", 
				threeDot("2103.120"), true);
		assertEquals("One decimal is alright", 
				threeDot("2103.1"), false);
		assertEquals("A dot is alright", 
				threeDot("2103."), false);
		assertEquals("Int is acceptable.", 
				threeDot("2103."), false);
		assertEquals("Four is not acceptable.", 
				threeDot("2103.4398"), true);
		System.out.println("ThreeDot(String): Unacceptable outputs "
				+ "return true. Acceptable inputs return false.");
	}
	@Test
	public void testIsAlphaNumeric() {
		assertEquals("Capital letters, lowercase, and numbers", 
				isAlphaNumeric("ABCDXYZabcxyz1012921"), true);
		assertEquals("Slash (one value below 0), false", 
				isAlphaNumeric("jk/7"), false);
		assertEquals("Slash (one value above 9), false", 
				isAlphaNumeric("jk:7"), false);
		assertEquals("Slash (one value below A), false", 
				isAlphaNumeric("jk@7"), false);
		assertEquals("Slash (one value above Z), false", 
				isAlphaNumeric("jk[7"), false);
		assertEquals("Slash (one value below a), false", 
				isAlphaNumeric("jk`7"), false);
		assertEquals("Slash (one value above z), false", 
				isAlphaNumeric("jk{7"), false);
		System.out.println("IsAlphaNumeric(String): Letters & "
				+ "numbers, return true. Anything else, return false.");
	}
}
