package com.revature.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.Q18;

class Q18Test {
	String check1 = "lowercase";
	String check3 = "7";

	@Test
	void test1() {
		assertEquals("This should only return true when there are no uppercase letters", false, Q18.upperChecker(check1));
	}
	@Test
	void test2()
	{
		assertEquals("This should set every letter in check1 to be uppercase.",true,Q18.upperChecker(Q18.upperConverter(check1)));
	}
	@Test
	void test3()
	{
		assertEquals("7+10 = 17",17,Q18.addToString(check3));
	}

}
