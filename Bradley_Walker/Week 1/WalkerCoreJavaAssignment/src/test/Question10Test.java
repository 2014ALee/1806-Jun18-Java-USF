package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import answers.Question10;

public class Question10Test {
	
	@Test
	public void testMin() {
		int x = (int) (Math.random() * 100);
		int y = (int) (Math.random() * 100);
		assertEquals("Testing min method", Math.min(x, y), Question10.min(x, y));
	}

}
