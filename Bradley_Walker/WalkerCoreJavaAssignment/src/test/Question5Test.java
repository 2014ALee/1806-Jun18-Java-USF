package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import answers.Question5;

public class Question5Test {
	
	@Test
	public void testSubString() {
		int index = 4;
		String string = "This is a string";
		String subString = string.substring(0, index);
		assertEquals("Testing the subString method", true, subString.equals(Question5.subString(string, index)));
	}

}
