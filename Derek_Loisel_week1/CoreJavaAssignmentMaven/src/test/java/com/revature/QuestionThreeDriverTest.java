package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuestionThreeDriverTest {

	@Test
	public void test() {
		
		//strings to compare
		String str = "siht esrever";
		String str2 = "reverse this";
		
		assertEquals("The reverseString() method didn't properly reverse the string", str, QuestionThreeDriver.reverseString(str2));
	}

}
