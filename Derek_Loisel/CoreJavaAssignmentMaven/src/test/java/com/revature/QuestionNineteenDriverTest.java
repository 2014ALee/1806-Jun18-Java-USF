package com.revature;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class QuestionNineteenDriverTest {

	@Test
	public void test() {
		
		//create properly sorted array to test against method
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		al1.add(1);
		al1.add(4);
		al1.add(6);
		al1.add(8);
		
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(1);
		al2.add(2);
		al2.add(3);
		al2.add(4);
		al2.add(5);
		al2.add(6);
		al2.add(7);
		al2.add(8);
		
		//check to make sure removePrimes returns an array list without the primes in it
		assertEquals("The removePrimes() method didn't return the correct ArrayList", al1.toString(), QuestionNineteenDriver.removePrimes(al2).toString());
	}

}
