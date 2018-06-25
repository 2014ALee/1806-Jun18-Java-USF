package answers.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import answers.Question2;

class Question2Test {

	@Test
	public void testFibonnaciNumber() {
		int[] test = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368};
		int[] fn = Question2.fibonnaciNumber();
		assertEquals(Arrays.toString(test), Arrays.toString(fn));
	}

}
