package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuestionSixteenDriverTest {

	@Test
	public void test() {
		
		//string to test 
		String testStr = "hi";
		
		//getArgsString() method should return hi from the array
		String[] strArr = new String[] {"hi", "hello", "no"};
		
		//the getArgsString() method should take in an array of strings and give back the first element in the array
		assertEquals("The getArgsString() method didn't return the correct string from the array", testStr, QuestionSixteenDriver.getArgsString(strArr));
	}

}
