package J_Unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import homework_week1.questions.Question16;



public class Question16Test {

	@Test
	public void testIfArgumentsPassed() {
		
		String[] argsToPass = new String[1];
		argsToPass[0] = "Tom";
		
		assertArrayEquals("User input is Tom, so that's what we're using as our"
				+ "String input", argsToPass, Question16.getStringFromUser());
	}

	@Test
	public void checkNumberOfCharacters() {
		
		String[] argsToPass = new String[1];
		argsToPass[0] = "Andrew";
		
		assertEquals("Andrew has 6 charachters in it", 6, Question16.numberOfChars(argsToPass));
	}
	
	
}
