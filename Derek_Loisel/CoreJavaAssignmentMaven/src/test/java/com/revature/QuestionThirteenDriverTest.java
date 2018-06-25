package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuestionThirteenDriverTest {

	@Test
	public void test() {
		
		//create a string to test against the createTriangle() method
		String testStr = "0\n10\n101\n0101\n";

		assertEquals("The createTriange() method didnt produce the correct string", testStr, QuestionThirteenDriver.createTriangle(4));
	}

}
