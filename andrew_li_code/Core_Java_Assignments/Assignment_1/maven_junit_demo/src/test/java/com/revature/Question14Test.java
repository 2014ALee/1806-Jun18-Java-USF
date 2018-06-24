package com.revature;

import static com.revature.Question14.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class Question14Test {

	@Test
	public void testSolveRoot() {
		assertEquals("Sqrt of 4", (int) solveRoot(4.1), 2);
		assertEquals("Sqrt of 25", (int) solveRoot(25.1), 5);
		assertEquals("Sqrt of 100", (int) solveRoot(100.1), 10);
		assertEquals("Sqrt of 49", (int) solveRoot(49.1), 7);
		System.out.println("Question 14 root tests passed");
	}
	@Test
	public void testGetDate() {
		assertEquals("Format of date", getDate().split("/").length , 3);
		System.out.println("Got format of date");
	}
	@Test
	public void testSplitArray() {
		String[] words = splitArray("a b c d e");
		assertEquals("length", words.length, 5);
		assertEquals("index a", words[0], "a");
		assertEquals("index b", words[1], "b");
		assertEquals("index c", words[2], "c");
		assertEquals("index d", words[3], "d");
		assertEquals("index e", words[4], "e");
		System.out.println("Split works fine");
	}
	@Test
	public void testGetPrinted() {
		assertEquals("When choosing option 1", getPrinted("1", 4.0).substring(
				0, 10), "The square");
		assertEquals("When choosing option 2", getPrinted("2", 4.0).substring(
				0, ("Today's date").length()), "Today's date");
		assertEquals("When choosing option 3", getPrinted("3", 4.0).substring(
				0, 6), "Stored");
		System.out.println("Switch/case test passed!");
	}

}
