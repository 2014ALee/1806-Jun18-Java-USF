package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.other.OtherClass;

public class Question11Test {

	@Test
	public void testOtherClass() {
		assertEquals("Accessing double from Other Class", 812,
				(int) OtherClass.FLOAT_1);
		assertEquals("Accessing double from Other Class", 531,
				(int) OtherClass.FLOAT_2);
		System.out.println("Passed tests for accessing doubles (Question 11)");
	}

}
