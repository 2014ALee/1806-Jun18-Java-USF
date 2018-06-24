package J_Unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import homework_week1.questions.Question14;

public class Question14Test {

	@Test
	public void testCase2Completed() {
		assertEquals("if the method completed the second tast case successfully, Case 2 Complete will be returned"
				, "Case 2 Complete", Question14.goToCases(2));

	}
}
