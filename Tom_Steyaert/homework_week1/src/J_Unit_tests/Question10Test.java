package J_Unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import homework_week1.questions.Question10;

public class Question10Test {

	@Test
	public void checkGetMinimumValue() {
		
		assertEquals("The minimum of 26 and -23 is -23", -23, Question10.getMinimumValue(26, -23));
		
	}

}
