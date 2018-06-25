package SourceMainJava.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import SourceMainJava.problemThree;

public class problemThreeTest {

	@Test
	public void test() {
		String str = "Hello";
		String reverse = "olleH";
		assertEquals(reverse, problemThree.reverseString(str));
	}

}
