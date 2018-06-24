package homework_week1.questions.question18;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question18Test {
	Subclass mySubclass = new Subclass();
	
	
	@Test
	public void testIfHasUpperCase() {
		
		assertEquals("The input text has one upper case P in it",
		true, mySubclass.hasUpperCase("is this upPer-case??"));
		
	}

	@Test
	public void testStringToIntegerPlus10() {

		assertEquals("ASCII a is 97 + ASCII b is 98 + 10 = 205", 205, mySubclass.toInteger("ab"));
		
	}
	
	@Test
	public void toUpperCaseTest() {
		
		assertEquals("Tom Steyaert becomes TOM STEYAERT", "TOM STEYAERT", mySubclass.toUpperCase("Tom Steyaert"));
		
	}
	
}
