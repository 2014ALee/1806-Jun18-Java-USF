package com.revature.testcases;

import static org.junit.Assert.assertArrayEquals;

import java.util.Vector;

import org.junit.Test;

import com.revature.Q2;

public class Q2Test {
	@Test
	public void fibTester()
	{
		Vector<Integer> expected = new Vector<Integer>(5);
		expected.add(1);
		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(5);
		expected.add(8);
		expected.add(13);
		expected.add(21);
		expected.add(34);
		expected.add(55);
		System.out.println("expected array: "+expected);
		Vector<Integer> theTest = new Vector<Integer>();
		//System.out.println("inputted array: "+Q2.fib(theTest, 10));
		//left that comment there because leaving that printscreen there screwed up the test case.
		assertArrayEquals("This should print the first 10 fibonacci numbers",expected.toArray(), Q2.fib(theTest, 10).toArray());
	}

}
