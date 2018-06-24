package answers.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import answers.Question5;

class Question5Test {

	@Test
	public void testSubStringHello4() {
		assertEquals("Hell", String.valueOf(Question5.substring("Hello", 4)));
	}
	
	@Test
	public void testSubStringHello5() {
		assertEquals("Hello", String.valueOf(Question5.substring("Hello", 5)));
	}

}
