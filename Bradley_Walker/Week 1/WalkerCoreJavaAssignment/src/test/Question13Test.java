package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import answers.Question13;

public class Question13Test {
	
	@Test
	public void testGenerateTriangle() {
		String triangle = "0\n10\n101\n0101\n";
		assertEquals("Testing triangle generation", true, triangle.equals(Question13.generateTriangle()));
	}

}
