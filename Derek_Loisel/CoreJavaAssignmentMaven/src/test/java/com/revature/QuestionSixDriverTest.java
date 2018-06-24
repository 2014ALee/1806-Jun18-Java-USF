package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuestionSixDriverTest {

	@Test
	public void test() {
		
		int oddInt = 7;
		String oddStr = "odd";
		
		int evenInt = 10;
		String evenStr = "even";
		
		assertEquals("The oddOrEvenInt(int) method didn't return the correct string", oddStr, QuestionSixDriver.oddOrEvenInt(oddInt));
		assertEquals("The oddOrEvenInt(int) method didn't return the correct string", evenStr, QuestionSixDriver.oddOrEvenInt(evenInt));
	}

}
