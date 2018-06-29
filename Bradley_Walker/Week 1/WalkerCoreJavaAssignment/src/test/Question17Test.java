package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import answers.Question17;

public class Question17Test {
	
	@Test
	public void testCalculateSimpleInterest() {
		assertEquals("Testing simple interest calculation", true, 6000.0 == Question17.calculateSimpleInterest(10, 20, 30));
	}

}
