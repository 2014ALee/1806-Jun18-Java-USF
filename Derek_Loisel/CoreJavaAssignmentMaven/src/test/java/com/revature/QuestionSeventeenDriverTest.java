package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuestionSeventeenDriverTest {

	@Test
	public void test() {
		
		//create a string to compare the functions result to
		String d = "5000.0";
		
		//create doubles to plug into the method to calculate interest
		double d1 = 100.0;
		double d2 = 5.0;
		double d3 = 10.0;
		
		//compare in string form since assertEquals with doubles is depricated because of precision loss
		String interest = Double.toString(QuestionSeventeenDriver.calculateInterest(d1, d2, d3));

		assertEquals("The calculateInterest() method didn't return the correct interest value", d, interest);
	}

}
