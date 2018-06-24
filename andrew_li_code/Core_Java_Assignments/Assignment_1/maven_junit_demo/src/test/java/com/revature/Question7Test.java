package com.revature;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.revature.Question7.EmployeeComparator;

public class Question7Test {

	@Test
	public void testComparator() {
		Question7.Employee e1 = new Question7.Employee("Lin", "Andrew", "CS", 23);
		Question7.Employee e2 = new Question7.Employee("Li", "Andrew", "CS", 24);
		Question7.Employee e3 = new Question7.Employee("Li", "Andrew", "CS", 22);
		Question7.Employee e4 = new Question7.Employee("Li", "Andrew", "MATH", 21);
		Question7.Employee e5 = new Question7.Employee("li", "aaron", "math", 21);
		Question7.Employee e6 = new Question7.Employee("Kessela", "algustus", "GDP", 21);
		Question7.Employee e7 = new Question7.Employee("kessel", "mathew", "ACC", 21);
		List<Question7.Employee> employees = new ArrayList<Question7.Employee>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		employees.add(e5);
		employees.add(e6);
		employees.add(e7);
		// Sanity Check;
		assertEquals("Make sure they're added in the right order",
			e1 == employees.get(0) && e2 == employees.get(1)
			&& e3 == employees.get(2) && e4 == employees.get(3)
			&& e5 == employees.get(4) && e6 == employees.get(5)
			&& e7 == employees.get(6), true);
		Collections.sort(employees, new Question7.EmployeeComparator());
		assertEquals("Last name in front", e7, employees.get(0));
		assertEquals("Longer name goes after", e6, employees.get(1));
		assertEquals("First name accounted for next", e5, employees.get(2));
		assertEquals("Age difference test", e3, employees.get(3));
		assertEquals("Age difference test", e2, employees.get(4));
		assertEquals("Department matters", e4, employees.get(5));
		assertEquals("Last name test", e1, employees.get(6));
		System.out.println("Question 7 Test Cases passed!");
	}
	@Test
	public void testStrCmp() {
		assertEquals("Caps don't matter", EmployeeComparator.strCmp("HELLO", "hello"), 0);
		assertEquals("Alphabetical", EmployeeComparator.strCmp("andrew", "blaire"), -1);
		assertEquals("Reverse", EmployeeComparator.strCmp("blaire", "andrew"), 1);
		assertEquals("Size matters in some cases", EmployeeComparator.strCmp("alex", "Alexander"), -1);
		System.out.println("Question 7 helper function passed!");
	}

}
