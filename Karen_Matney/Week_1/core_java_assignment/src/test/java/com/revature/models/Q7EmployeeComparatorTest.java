package com.revature.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q7EmployeeComparatorTest {

	// Testing compareString, First/shorter is smaller than last/longer
	@Test
	public void firstFirst() {
		Q7EmployeeComparator test = new Q7EmployeeComparator();
		assertEquals("First is First",-1, test.compareString("Riley","Samantha"));
	}
	
	@Test
	public void lastFirst() {
		Q7EmployeeComparator test = new Q7EmployeeComparator();
		assertEquals("First is First",1, test.compareString("Samantha","Riley"));
	}

	@Test
	public void same() {
		Q7EmployeeComparator test = new Q7EmployeeComparator();
		assertEquals("First is First",0, test.compareString("Riley","Riley"));
	}
	
	@Test
	public void leftSameButLonger() {
		Q7EmployeeComparator test = new Q7EmployeeComparator();
		assertEquals("First is First",1, test.compareString("Rileysmith","Riley"));
	}
	
	@Test
	public void rightSameButLonger() {
		Q7EmployeeComparator test = new Q7EmployeeComparator();
		assertEquals("First is First",-1, test.compareString("Riley","Rileysmith"));
	}
}
