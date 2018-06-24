package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import answers.Question7;
import answers.Question7.Employee;

public class Question7Test {
	private static ArrayList<Employee> employees;
	
	@Before
	public void setEmployees() {
		employees = new ArrayList<>();
		employees.add(new Employee("John", "Sales", 32));
		employees.add(new Employee("Karen", "HR", 28));
		employees.add(new Employee("Bob", "R&D", 39));
		employees.add(new Employee("Bob", "R&D", 38));
	}
	
	@Test
	public void testSortByName() {
		ArrayList<Employee> result = new ArrayList<>();
		for(Employee e : employees)
			result.add(e);
		result.sort((Employee emp1, Employee emp2)->{
			return emp1.name.compareTo(emp2.name);
		});
		assertEquals("Testing sort by name", true, result.equals(Question7.sortByName(employees)));
	}

	@Test
	public void testSortByDepartment() {
		ArrayList<Employee> result = new ArrayList<>();
		for(Employee e : employees)
			result.add(e);
		result.sort((Employee emp1, Employee emp2)->{
			return emp1.department.compareTo(emp2.department);
		});
		assertEquals("Testing sort by department", true, result.equals(Question7.sortByDepartment(employees)));
	}
	
	@Test
	public void testSortByAge() {
		ArrayList<Employee> result = new ArrayList<>();
		for(Employee e : employees)
			result.add(e);
		result.sort((Employee emp1, Employee emp2)->{
			return Integer.compare(emp1.age, emp2.age);
		});
		assertEquals("Testing sort by age", true, result.equals(Question7.sortByAge(employees)));
	}
}
