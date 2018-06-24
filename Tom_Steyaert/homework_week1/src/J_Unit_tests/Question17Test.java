package J_Unit_tests;

import static org.junit.Assert.*;
import java.util.InputMismatchException;
import org.junit.Test;

import homework_week1.questions.Question17;

public class Question17Test {

	@Test(expected = InputMismatchException.class)
	public void calculateInterestWithBadInputs() {	

		Question17.calculateInterest();
	}

}
