package J_Unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import homework_week1.questions.Question3;

public class Question3Test {

	@Test
	public void checkReverseString() {
		assertEquals("Andrew backwards is werdnA", "werdnA", Question3.reverseString("Andrew"));
	}

}
