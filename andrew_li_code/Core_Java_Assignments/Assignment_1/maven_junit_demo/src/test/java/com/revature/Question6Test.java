package com.revature;

import static com.revature.Question6.isEven;
import static org.junit.Assert.*;

import org.junit.Test;

public class Question6Test {

	@Test
	public void testIsEven() {
		assertEquals("6 is even", isEven(6), true);
		assertEquals("146 is even", isEven(146), true);
		assertEquals("8705 is odd", isEven(8705), false);
		assertEquals("7710 is even", isEven(7710), true);
		assertEquals("1011 is even", isEven(1011), false);
		System.out.println("Question 6 test cases passed!");
	}

}
