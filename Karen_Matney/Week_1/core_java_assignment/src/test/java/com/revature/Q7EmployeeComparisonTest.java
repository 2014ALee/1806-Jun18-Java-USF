/*
 * Work on it more...
 */
package com.revature;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature.models.Q7Employee;

public class Q7EmployeeComparisonTest {

	@Test
	public void onName() {
		List<Q7Employee> test = new ArrayList<>();
		test.add(new Q7Employee("Jane Smith","Sales",37));
		test.add(new Q7Employee("Roger Smith","Sales",37));
		test.add(new Q7Employee("Janey Smith","Sales",37));
		
		List<Q7Employee> ordered = new ArrayList<>();
		ordered.add(new Q7Employee("Jane Smith","Sales",37));
		ordered.add(new Q7Employee("Janey Smith","Sales",37));
		ordered.add(new Q7Employee("Roger Smith","Sales",37));
		
		assertEquals("ArrayList in order", ordered,Q7EmployeeComparison.sortEmployees(test));
	}
	
	@Test
	public void onDepartment() {
		List<Q7Employee> test = new ArrayList<>();
		test.add(new Q7Employee("Jane Smith","Software Developer II",37));
		test.add(new Q7Employee("Jane Smith","IT",37));
		test.add(new Q7Employee("Jane Smith","Software Developer",37));
		
		List<Q7Employee> ordered = new ArrayList<>();
		ordered.add(new Q7Employee("Jane Smith","IT",37));
		ordered.add(new Q7Employee("Jane Smith","Software Developer",37));
		ordered.add(new Q7Employee("Jane Smith","Software Developer II",37));
		
		assertEquals("ArrayList in order", ordered,Q7EmployeeComparison.sortEmployees(test));
	}
	
	@Test
	public void onAge() {
		List<Q7Employee> test = new ArrayList<>();
		test.add(new Q7Employee("Jane Smith","Software Developer",37));
		test.add(new Q7Employee("Jane Smith","Software Developer",27));
		test.add(new Q7Employee("Jane Smith","Software Developer",22));
		
		List<Q7Employee> ordered = new ArrayList<>();
		ordered.add(new Q7Employee("Jane Smith","Software Developer",22));
		ordered.add(new Q7Employee("Jane Smith","Software Developer",27));
		ordered.add(new Q7Employee("Jane Smith","Software Developer",37));
		
		assertEquals("ArrayList in order", ordered,Q7EmployeeComparison.sortEmployees(test));
	}

}
