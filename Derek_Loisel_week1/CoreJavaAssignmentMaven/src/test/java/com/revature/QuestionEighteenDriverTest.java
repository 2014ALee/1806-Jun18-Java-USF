package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuestionEighteenDriverTest {

	@Test
	public void test() {
		
		//create strings to test
		String testString1 = "Upper";
		String testString2 = "upper";
		String testString3 = "UPPER";
		String testString4 = "10";
		int testInt = 20;
		
		QuestionEighteenDriver qed = new QuestionEighteenDriver();
		
		//test hasUpper() method 
		assertTrue("The hasUpper() method didn't return the correct boolean", qed.hasUpperCase(testString1));
		assertFalse("The hasUpper() method didn't return the correct boolean", qed.hasUpperCase(testString2));
		
		//test convertToUpper() method
		assertEquals("The convertToUpper() method didn't return the correct string", testString3, qed.convertToUpper(testString2));
		
		//test printStringToIntPlusTen() method
		assertEquals("The printStringToIntPlusTen() method didn't return the correct int", testInt, qed.printStringToIntPlusTen(testString4));
	}

}
