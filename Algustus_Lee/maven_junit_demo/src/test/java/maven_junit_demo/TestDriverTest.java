package maven_junit_demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.TestDriver;

/*
 * Write a test case for every method in the class. 
 * Test cases never have a main function
 */

public class TestDriverTest {
	@Test //used for testing in jUnit
	//assertequals() tests that two values are the same. it's like == operator
	//NOTE: Arrays / objects have their references checked, not the content or states.
	public void testMultiply()
	{
		TestDriver tester = new TestDriver();
		assertEquals("10x5 must equal 50", 50, tester.multiply(10, 5));
	}
	@Test
	public void fakeTest()
	{
		return;
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testExceptionIsThrown()
	{
		TestDriver tester = new TestDriver();
		tester.multiply(1000, 5);
	}
	

}
