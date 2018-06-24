package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import answers.Question19;

public class Question19Test {
	
	ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
	
	@Test
	public void testAddEvens() {
		assertEquals("Testing even addition", 30, Question19.addEvens(nums));
	}
	
	@Test
	public void testAddOdds() {
		assertEquals("Testing odd addition", 25, Question19.addOdds(nums));
	}

}
