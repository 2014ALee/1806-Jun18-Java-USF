package J_Unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import homework_week1.questions.Question13;

import java.util.LinkedList;

public class Question13Test {

	@Test
	public void numberToAddToTriangleLine() {
		
		assertEquals("if our line number is 4, we're adding a 0 to our printed line", 0, Question13.numberToAppend(4));		
	}
	
	@Test
	public void checkTriangleLine4() {
		
		//we add 0 1 0 1 into our linkedList, which holds our triangle line
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(0);
		linkedList.add(1);
		linkedList.add(0);
		linkedList.add(1);
		
		assertEquals("the triangle's fourth line will be 0 1 0 1", linkedList, Question13.getTriangleLine(4));
	}

}
