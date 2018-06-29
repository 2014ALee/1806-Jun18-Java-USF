package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import answers.Question18Concrete;

public class Question18Test {
	Question18Concrete q18 = new Question18Concrete();
	
	@Test
	public void testContainsUppercase() {
		String str = "This is a test string";
		assertEquals("Testing uppercase", !str.equals(str.toLowerCase()), q18.containsUppercase(str));
	}

	@Test
	public void testToUpperCase() {
		String str = "This is another test string";
		assertEquals("Testing cas conversion", true, str.toUpperCase().equals(q18.toUpperCase(str)));
	}
	
	@Test
	public void testToInt() {
		String str = "15";
		assertEquals("Testing integer conversion", 25, q18.toInt(str));
	}
}
