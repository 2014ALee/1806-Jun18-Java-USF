package answers.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import answers.Question19;

class Question19Test {
	
	@Test
	public void testAddEvens() {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		assertEquals(12, Question19.addEvens(arr));
	}
	
	@Test
	public void testAddOdds() {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		assertEquals(9, Question19.addOdds(arr));
	}

	@Test
	public void testRemovePrimes() {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		ArrayList<Integer> noPrimes = new ArrayList<>(Arrays.asList(1, 4, 6));
		Question19.removePrimes(arr);
		assertTrue(noPrimes.equals(arr));
	}
}
