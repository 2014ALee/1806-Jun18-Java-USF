package com.revature;
import java.util.Arrays;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.EmployeeCompare;
public class Employees {
	static Employee emp1 = new Employee("Tom Jones", 45, "asfd Service");
	static Employee emp2 = new Employee("Harry Major", 10,"Customer Service");
	static List<Employee> employeeList = Arrays.asList(emp1, emp2);
	public static void main(String[] args) {
		EmployeeCompare empComp = new EmployeeCompare();
		employeeList.sort(empComp);
		employeeList.forEach(System.out::println);
	}
}

