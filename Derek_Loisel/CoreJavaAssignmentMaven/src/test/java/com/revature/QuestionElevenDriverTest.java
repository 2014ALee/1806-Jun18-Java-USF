/**
 * 
 */
package com.revature;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class QuestionElevenDriverTest {

	
	@Test
	public void test() {
		
		//create floats to test that are equal to the ones in QuestionEleven that retrieveTwoFloats() returns
		float f1 = 2.3456f;
		float f2 = 3.4456f;
		ArrayList<Float> alf = new ArrayList<Float>();
		alf.add(f1);
		alf.add(f2);
		
		assertEquals("The method didn't correctly retrieve the float variable", alf.toString(), QuestionElevenDriver.retrieveTwoFloats().toString());
	}

}
