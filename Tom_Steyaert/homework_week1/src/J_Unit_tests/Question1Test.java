package J_Unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import homework_week1.questions.Question1;

public class Question1Test {

	@Test
	public void test() {
		
		int[] unsortedArray = {1,0,5,6,3,2,3,7,9,8,4};
		int[] sortedArray = {0,1,2,3,3,4,5,6,7,8,9};
		
		assertArrayEquals("array:{1,0,5,6,3,2,3,7,9,8,4} is sorted", sortedArray, Question1.bubbleSort(unsortedArray));
	}
}
