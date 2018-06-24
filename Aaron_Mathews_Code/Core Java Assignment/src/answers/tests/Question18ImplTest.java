package answers.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import answers.Question18Impl;

class Question18ImplTest {
	Question18Impl ques = new Question18Impl();
	
	@Test
	public void testHasUpper() {
		String str = "Hello";
		assertTrue(ques.hasUpper(str));
	}
	
	@Test 
	public void testToUpper() {
		String str = "HELLO";
		assertEquals(String.valueOf(str), String.valueOf(ques.toUpper("hello")));
	}
	
	@Test
	public void testStringIntValue() {
		assertEquals(97, ques.stringIntValue("Hello"));
	}

}
