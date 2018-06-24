package com.revature;

import static com.revature.Question19.generate;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Question19Test {

	@Test
	public void testGenerate() {
		Question19 obj = generate(10);
		ArrayList<Integer> ourArrayList = obj.getArrayList();
		assertEquals("Checking 1", ourArrayList.get(0) == 1, true);
		assertEquals("Checking 2", ourArrayList.get(1) == 2, true);
		assertEquals("Checking 3", ourArrayList.get(2) == 3, true);
		assertEquals("Checking 4", ourArrayList.get(3) == 4, true);
		assertEquals("Checking 5", ourArrayList.get(4) == 5, true);
		assertEquals("Checking 6", ourArrayList.get(5) == 6, true);
		assertEquals("Checking 7", ourArrayList.get(6) == 7, true);
		assertEquals("Checking 8", ourArrayList.get(7) == 8, true);
		assertEquals("Checking 9", ourArrayList.get(8) == 9, true);
		assertEquals("Checking 10", ourArrayList.get(9) == 10, true);
		System.out.println(ourArrayList);
		int evenSum = obj.getEvenSum();
		int oddSum = obj.getOddSum();
		assertEquals("Even sum is 30", evenSum, 30);
		assertEquals("Even sum is 25", oddSum, 25);
		System.out.println("Even sum: " + evenSum);
		System.out.println("Odd sum: " + oddSum);
	}

	@Test
	public void testRemovePrimes() {
		Question19 obj = generate(10);
		obj.removePrimes();
		ArrayList<Integer> ourArrayList = obj.getArrayList();
		assertEquals("Checking 1", ourArrayList.get(0) == 1, true);
		assertEquals("Checking 4", ourArrayList.get(1) == 4, true);
		assertEquals("Checking 6", ourArrayList.get(2) == 6, true);
		assertEquals("Checking 8", ourArrayList.get(3) == 8, true);
		assertEquals("Checking 9", ourArrayList.get(4) == 9, true);
		assertEquals("Checking 10", ourArrayList.get(5) == 10, true);
		System.out.println(ourArrayList);
		System.out.println("Prime number removal works!");
		
	}

}
