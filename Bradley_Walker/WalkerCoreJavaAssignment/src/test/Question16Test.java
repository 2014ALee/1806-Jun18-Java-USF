package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import answers.Question16;

public class Question16Test {
	
	@Test
	public void testNumChars() {
		assertEquals("Testing character count", 5, Question16.numChars("12345"));
	}

}
