package com.revature;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import com.revature.Driver;

public class DriverTest {

	 Driver tester = new Driver();
	
	@Test
	public void testBubbleSort( ) {
		tester.bubbleSort();;
	}
	
	@Test
	public void testFib() {
		tester.fib();
	}
	
	@Test
	public void testStrReverse() {
		assertEquals("Hello must reverse to olleH", "olleH", tester.strReverse("Hello"));
	}
	
	@Test
	public void testFactorialOfN() {
		assertEquals("5! must equal 120", 120, tester.factorialOfN(5L));
	}
	
	@Test
	public void testSubStr() {
		assertEquals("The first 4 characters to\"Hello, World!\" must be Hell", "Hell", tester.subStr("Hello, World!", 4));
	}
	
	@Test
	public void testIsEven1() {
		assertEquals("4 must be even", true, tester.isEven(4));
	}
	
	@Test
	public void testIsEven2() {
		assertEquals("9 must be odd", false, tester.isEven(9));
	}
	
	@Test
	public void testEmployeeSort() {
		tester.employeeSort();
	}
	
	@Test
	public void testFindPalindromes() {
		tester.findPalindromes();
	}
	
	@Test
	public void testPrimesToN() {
		tester.primesToN(100);
	}
	
	@Test
	public void testMin1() {
		assertEquals("2 must be less than 5", 2, tester.min(2, 5));
	}
	
	@Test
	public void testMin2() {
		assertEquals("5 must be less than 8", 5, tester.min(5, 8));
	}
	
	@Ignore
	public void testCompareOther() {
		assertEquals("3.14 must be less than 42.42", 3.14f, tester.compareOther());
	}
	
	@Test
	public void testEvenTo100() {
		tester.evenTo100();
	}
	
	@Test
	public void testTriangle() {
		tester.triangle();
	}
	
	@Test
	public void testSwitchCase1() {
		tester.switchCase(1);
	}
	
	@Test
	public void testSwitchCase2() {
		tester.switchCase(2);
	}
	
	@Test
	public void testSwitchCase3() {
		tester.switchCase(3);
	}
	
	@Test
	public void testArithmetic() {
		tester.artihmetic();
	}
	
	@Test
	public void testStrLen() {
		assertEquals("\"Hello, World!\" must have 13 characters", 13, tester.strLen("Hello, World!"));
	}
	
	@Test
	public void testInterestCalculator() {
		tester.interestCalculator();
	}
	
	@Test
	public void testInheritance() {
		tester.inheritance();
	}
	
	@Test
	public void testListMath() {
		tester.listMath();
	}
	
	public void testFileReader() {
		tester.fileReader();
	}

}
