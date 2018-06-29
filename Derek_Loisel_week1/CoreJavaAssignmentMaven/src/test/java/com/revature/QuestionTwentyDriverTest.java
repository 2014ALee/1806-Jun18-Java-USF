package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuestionTwentyDriverTest {

	@Test
	public void test() {
		
		//created a properly formatted string that should match the formatted string from formatFileText
		String testStr = "Name: Mickey Mouse\n" + "Age: 35 years\n" + "State: Arizona State\n\n" +
				"Name: Hulk Hogan\n" + "Age: 50 years\n" + "State: Virginia State\n\n" +			 
				"Name: Roger Rabbit\n" + "Age: 22 years\n" + "State: California State\n\n" + 
				"Name: Wonder Woman\n" + "Age: 18 years\n" + "State: Montana State\n\n";

		assertEquals("The formatFileText() method didnt correctly format the text from the file", testStr, QuestionTwentyDriver.formatFileText());
				
	}

}
