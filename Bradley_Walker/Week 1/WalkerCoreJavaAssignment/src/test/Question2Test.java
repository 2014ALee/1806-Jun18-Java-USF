package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import answers.Question2;

public class Question2Test {
	
	@Test
	public void testFibonacci() {
		ArrayList<Integer> fibs = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144));
		assertEquals("The first 13 fibonacci numbers", true, fibs.equals(Question2.fibonacci(13)));
	}

}
