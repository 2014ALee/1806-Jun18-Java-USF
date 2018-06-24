package J_Unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import homework_week1.questions.Question6;

public class Question6Test {

	@Test
	public void is10Even() {
		assertEquals("10 is even", true, Question6.isEven(10));
	}

}
