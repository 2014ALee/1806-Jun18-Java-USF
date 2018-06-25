package com.revature;
import static org.junit.Assert.assertEquals; // we import static only when we want static stuff

import org.junit.Test;

public class TestDriverTest {
	
	@Test //the method or code that follows this is the thing to be run by maven
	 
	
	//assertEquals()tests that two values are the same
	//NOTE: with arrays and objects, the reference is checked not the contents are value
	public void testMulitply () {
		TestDriver tester = new TestDriver();
		assertEquals("10 * 5 must equal 50", 50, tester.multiply(10, 5)); //is a static method from the assert calss which hold an abundance of test methods
		
		//I can find all of them on the junitsourceforge.net
	
	}
	
	@Test (expected = IllegalArguementException.class)
	public void testExceptionIsThrown() {
		TestDriver tester = new TestDriver() ;
		tester.multiply(1000, 5);
		
	}
	
	

}
