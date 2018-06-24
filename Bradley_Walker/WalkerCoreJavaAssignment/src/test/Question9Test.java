package test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import answers.Question9;

public class Question9Test {
	
	@Test
	public void testIsPrime() {
		HashMap<Integer, Boolean> testCases = new HashMap<>();
		testCases.put(1, false);
		testCases.put(2, true);
		testCases.put(3, true);
		testCases.put(4, false);
		testCases.put(5, true);
		testCases.put(6, false);
		testCases.put(7, true);
		testCases.put(8, false);
		testCases.put(9, false);
		testCases.put(10, false);
		testCases.put(11, true);
		
		for(Map.Entry<Integer, Boolean> entry : testCases.entrySet())
			assertEquals("Testing primeness", entry.getValue(), Question9.isPrime(entry.getKey()));
	}

}
