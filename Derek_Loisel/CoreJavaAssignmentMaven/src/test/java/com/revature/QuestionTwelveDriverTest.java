package com.revature;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class QuestionTwelveDriverTest {

	@Test
	public void test() {
		//create an array of inits 1 - 100 to compare to createArray() function
		int[] testArr = new int[100];
		for (int i = 1; i <= testArr.length; i++) {
			testArr[i - 1] = i;
		}
		//test that the test array matches the createArray() method
		assertEquals("The createArray() method didnt create the correct array", Arrays.toString(testArr), Arrays.toString(QuestionTwelveDriver.createArray()));
	}

}
