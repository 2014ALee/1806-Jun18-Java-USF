package com.revature;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class QuestionNineDriverTest {

	@Test
	public void test() {
		//create a properly sorted array list of primes
		ArrayList<Integer> ar1 = new ArrayList<Integer>();
		ar1.add(2);
		ar1.add(3);
		ar1.add(5);
		ar1.add(7);
		ar1.add(11);
		//create an array list to test sort
		ArrayList<Integer> ar2 = new ArrayList<Integer>();
		ar2.add(2);
		ar2.add(3);
		ar2.add(4);
		ar2.add(5);
		ar2.add(6);
		ar2.add(7);
		ar2.add(8);
		ar2.add(9);
		ar2.add(10);
		ar2.add(11);
		//test the getPrimes() method on the unsorted array list
		ArrayList<Integer> primesList = QuestionNineDriver.getPrimes(ar2);
		//compare the array lists
		
		assertEquals("The getPrimes() method didn't return the correct array list of primes", ar1.toString(), primesList.toString());
	}

}
