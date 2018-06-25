package com.revature;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/*
 * JUnit allows you to use parameters in a tests class. This class can contain one test method and this 
 * method is executed with the different parameters provided. You mark a test class as a parameterized 
 * test with the @RunWith(Parameterized.class) annotation. 
 * 
 * Such a test class must contain a static method annotated with the @Parameters annotation. That method 
 * generates and returns a collection of arrays. Each item in this collection is used as parameter for 
 * the test method.
 */
@RunWith(Parameterized.class)
public class TestDriverTest {

	/*
	 * We can test to make sure that exceptions are thrown when they should be. Simply indicate what
	 * exception is expected using parenthesis next to the @Test annotation.
	 * 
	 * Fails if the method does not throw the named exception. Test will fail if a more generic
	 * exception is thrown, but will pass if a more specific exception (a subclass of the expected)
	 * is thrown.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionIsThrown() {
		TestDriver tester = new TestDriver();
		tester.multiply(1000, 5);
	}

	/*
	 * assertEquals() tests that two values are the same. Note: for arrays the reference is checked not the content of the arrays.
	 */
	@Test
	public void testMultiply() {
		TestDriver tester = new TestDriver();
		assertEquals("10 x 5 must be 50", 50, tester.multiply(10, 5)); 
	}

	/*
	 * You can use the @Parameter annotation on public fields to get the test values injected in the test.
	 * Fields used together with @Parameter must be public
	 */
    @Parameter(0)
    public int m1;
    @Parameter(1)
    public int m2;
    @Parameter(2)
    public int result;


    // creates the test data
    @Parameters
    public static Collection<Object[]> data() {
    	// Here we initialize our parameters: { 1, 2, 2 } = { m1, m2, result }
    	// This allows us to write a single test case that tests multiple values
        Object[][] data = new Object[][] { { 1, 2, 2 }, { 5, 3, 15 }, { 121, 4, 484 } };
        return Arrays.asList(data);
    }


    @Test
    public void testMultiplyException() {
        TestDriver tester = new TestDriver();
        assertEquals("Result", result, tester.multiply(m1, m2));
    }
}