package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.EmployeeAgeComparator;

public class Q7 {

	public static void main(String[] args) {
		
		Employee emp1 = new Employee("John", 23, "IT");
		Employee emp2 = new Employee("Bill", 53, "Human Resources");
		Employee emp3 = new Employee("Sam", 32, "Sales");

		List<Employee> list = new ArrayList<>();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		EmployeeAgeComparator ageComparator = new EmployeeAgeComparator();
		
		list.sort(ageComparator);
		
		System.out.println("Employees sorted by age: ");
		for (Employee emp : list) {
			System.out.println(emp);
		}
		
	}

}
