package J_Unit_tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import homework_week1.questions.question7.Employee;
import homework_week1.questions.question7.EmployeeComparator;

public class Question7Test {


	@Test
	public void correctlySortEmployees() {	
		
		Employee tom = new Employee("Tom", "Steyaert", "Software", 22);
		Employee andrew = new Employee("Andrew", "Li", "Software", 23);
		Employee bert = new Employee("Bert", "Steyaert", "HR", 21);
		Employee amanda = new Employee("Amanda", "Steyaert", "Customer Service", 23);

		Employee[] employeesUnsorted = new Employee[4];

		employeesUnsorted[0] = tom;
		employeesUnsorted[1] = andrew;
		employeesUnsorted[2] = bert;
		employeesUnsorted[3] = amanda;

		Employee[] employeesSorted = new Employee[4];
		employeesSorted[0] = andrew;
		employeesSorted[1] = amanda;
		employeesSorted[2] = bert;
		employeesSorted[3] = tom;

		EmployeeComparator comparator = new EmployeeComparator();
		
		Arrays.sort(employeesUnsorted,comparator);
					
		assertArrayEquals("order in the unsorted arrray should become andrew, amanda, bert, then tom",
				employeesSorted, employeesUnsorted);		
	}
}

