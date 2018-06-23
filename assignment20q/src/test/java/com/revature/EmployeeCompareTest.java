package com.revature;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import com.revature.models.Employee;
import com.revature.models.EmployeeCompare;

public class EmployeeCompareTest {

	@Test
	public void testCompare() {
		Employee emp1 = new Employee("Tom Jones", 45, "asfd Serviced");
		Employee emp2 = new Employee("Tom Jones", 45, "asfd Serviced");
		List<Employee> employeeList = Arrays.asList(emp1, emp2);
		EmployeeCompare empComp = new EmployeeCompare();
		employeeList.sort(empComp);
		assertTrue("They are not equal",empComp.compare(emp1, emp2) == 0);
	}

}
