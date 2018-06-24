package J_Unit_tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

import homework_week1.questions.Question19;

public class Question19Test {


	@Test
	public void testEvenSum() {
		ArrayList<Integer> myArrayList= new ArrayList<Integer>();	
		int arrayListSize = 10;

		for(int i = 1 ; i <= arrayListSize ; i++) {
			myArrayList.add(i);
		}

		assertEquals("the even sum from 1 to 10 is 30", 30, Question19.getEvenSum(myArrayList));
	}

	@Test
	public void testOddSum() {
		ArrayList<Integer> myArrayList= new ArrayList<Integer>();	
		int arrayListSize = 10;

		for(int i = 1 ; i <= arrayListSize ; i++) {
			myArrayList.add(i);
		}

		assertEquals("the odd sum from 1 to 10 is 30", 25, Question19.getOddSum(myArrayList));
	}

	@Test
	public void testRemaindingPrimes() {
		
		//we fill in our arrays with the values we need
		ArrayList<Integer> myArrayList= new ArrayList<Integer>();	
		ArrayList<Integer> listWithoutPrimes= new ArrayList<Integer>();	

		int arrayListSize = 10;

		for(int i = 1 ; i <= arrayListSize ; i++) {
			myArrayList.add(i);
		}
		
		listWithoutPrimes.add(1);
		listWithoutPrimes.add(4);
		listWithoutPrimes.add(6);
		listWithoutPrimes.add(8);
		listWithoutPrimes.add(9);
		listWithoutPrimes.add(10);
		
		assertEquals("out list of numbers should be 1, 4, 6, 8, 9, 10",
		listWithoutPrimes, Question19.removePrimes(myArrayList));
	}
}

