package com.revature;

import static com.revature.Question16.getPrintedStatement;
import static org.junit.Assert.*;

import org.junit.Test;

public class Question16Test {

	@Test
	public void test() {
		assertEquals("Testing the print statement for sentence"
				+ "\"I am great!\"", getPrintedStatement("I am great!"),
				"The number of characters in the input is 11.");
		assertEquals("Testing the print statement for sentence"
				+ "\"Might\"", getPrintedStatement("Might"),
				"The number of characters in the input is 5.");
		System.out.println("Print tests passed!");
	}

}
