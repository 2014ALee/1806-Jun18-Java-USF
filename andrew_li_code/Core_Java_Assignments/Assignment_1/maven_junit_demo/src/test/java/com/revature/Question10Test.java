package com.revature;

import static com.revature.Question10.minimum;
import static org.junit.Assert.*;

import org.junit.Test;

public class Question10Test {

	@Test
	public void testMinimum() {
		assertEquals("-1 is less than 0", minimum(-1, 0), -1);
		assertEquals("2 is less than 100", minimum(2, 100), 2);
		assertEquals("-100 is less than 2", minimum(2, -100), -100);
		assertEquals("32 is less than 40", minimum(32, 40), 32);
		assertEquals("-21 is less than -5", minimum(-5, -21), -21);
		System.out.println("Test Cases for Question 10 have passed!");
	}

}
