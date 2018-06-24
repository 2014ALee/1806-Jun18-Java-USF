package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import answers.Question6;

public class Question6Test {
	
	@Test
	public void testIsEven() {
		for(int i = -10; i < 10; i++)
			assertEquals("Testing if the 20 numbers surrounding 0 are even or odd", i % 2 == 0, Question6.isEven(i));
	}

}
