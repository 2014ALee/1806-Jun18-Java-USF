package com.revature.utils;

import static com.revature.utils.StringHandler.*;
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
		assertEquals("Cannot start with number.", 
				isAlphaNumeric("234AYZabcxyz1012921"), false);
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
				+ "numbers (starting with letter), return true. "
				+ "Anything else, return false.");
	}
	
	@Test
	public void testHash() {
		String str1 = "a84w9ptrdfg;kds32";
		String str1Copy = new String("a84w9ptrdfg;kds32");
		String str2 = "a84w9ptrdfgikds32";
		assertEquals("Strings that are equal have the same hash",
				hash(str1).equals(hash(str1Copy)), true);
		assertEquals("If it's off by one letter then it should be"
				+ " hashed completely to something else.",
				hash(str1).equals(hash(str2)), false);
		System.out.println("Hash(String) very likely returns a "
				+ "different value for differet strings, "
				+ "but will return the same value for a same string.");
	}
	
	@Test
	public void testFixCommand() {
		String withSquareBrackets = " [Log in]   ";
		String plainCommand = "Log in";
		assertEquals("If the user copies teh square brackets then "
				+ " why not just handle it?", fixCommand(
						withSquareBrackets).equals("Log in"), true);
		assertEquals("Of course we do not want it to mess up "
				+ "something that is already correct.", fixCommand(
						plainCommand).equals("Log in"), true);
		System.out.println("FixCommand(String) does not mess anything "
				+ "up, only takes care of a potential mistake.");
		
	}
	
	@Test
	public void testAmountToString() {
		assertEquals("One scenario, if we have an integer.",
				amountToString(100).equals("100.00"), true);
		assertEquals("One scenario, if we nothing in dimes.",
				amountToString(150.02).equals("150.02"), true);
		assertEquals("One scenario, if we have nothing in single pennies.",
				amountToString(199.9).equals("199.90"), true);
		assertEquals("Taking care of extra decimals",
				amountToString(1210.121).equals("1210.12"), true);
		assertEquals("Taking care of dimes.",
				amountToString(0.2).equals("0.20"), true);
		assertEquals("Taking care of pennies.",
				amountToString(0.05).equals("0.05"), true);
		assertEquals("Taking care of under a dollar.",
				amountToString(0.92).equals("0.92"), true);
		System.out.println("Conversion works");
		
	}
}
