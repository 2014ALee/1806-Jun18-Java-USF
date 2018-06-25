package com.revature;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class PrintPrimesTest {

	@Test
	public void testGetPrimes() {
		ArrayList<Integer> solution = new ArrayList<>();
		solution.add(2);
		solution.add(3);
		solution.add(5);
		solution.add(7);
		solution.add(9);
		solution.add(11);
		
		ArrayList<Integer> test = new ArrayList<>();
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		test.add(10);
		test.add(11);
		
		System.out.println(solution.toString());
		System.out.println(test.toString());
		
		assertEquals("",  solution, PrintPrimes.getPrimes(test));
	}

}
