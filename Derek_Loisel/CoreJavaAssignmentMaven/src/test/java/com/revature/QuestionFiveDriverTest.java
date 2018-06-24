package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuestionFiveDriverTest {

	@Test
	public void test() {
		
		//strings to test the subString(String, int) method to return the substring up to inx-1 inclusive
		String str1 = "Hello";
		String str2 = "Hello There";
		
		assertEquals("The subString() method didn't return the proper substring", str1, QuestionFiveDriver.subString(str2, 5));
	}

}
