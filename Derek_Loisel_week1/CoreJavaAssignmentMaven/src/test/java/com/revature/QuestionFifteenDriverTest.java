package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.models.QuestionFifteen;

public class QuestionFifteenDriverTest {

	@Test
	public void test() {

		//create a double represented by string to test the methods
		String d = "8.0";
		
		QuestionFifteen qf = new QuestionFifteen();
		
		//compare math methods as strings to avoid precision loss deprication
		assertEquals("The addition() method didn't produce the correct answer", d, Double.toString(qf.addition(4, 4)));
		assertEquals("The subtraction() method didn't produce the correct answer", d, Double.toString(qf.subtraction(10, 2)));
		assertEquals("The multiplication() method didn't produce the correct answer", d, Double.toString(qf.multiplication(4, 2)));
		assertEquals("The division() method didn't produce the correct answer", d, Double.toString(qf.division(24, 3)));
	}

}
