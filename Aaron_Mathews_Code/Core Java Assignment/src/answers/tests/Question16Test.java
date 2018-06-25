package answers.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import answers.Question16;

class Question16Test {

	@Test
	public void testCharCounter() {
		String[] str  = {"Hello," , "world!"};
		//13 String chars but method calls join() with " ".
		assertEquals(13, Question16.charCounter(str));
	}

}
