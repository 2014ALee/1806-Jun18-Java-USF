package com.revature;

import java.util.ArrayList;

import com.revature.models.Employee;
import com.revature.models.EmployeeAgeComparator;

public class ComparatorDriver {
	
	public void main(String[] args) {
		
	Employee emp1 = new Employee("John Beineke", 23, "IT");
	Employee emp2 = new Employee("Bob Smith", 54, "Human Resources");
	
	EmployeeAgeComparator ageComparator = new EmployeeAgeComparator();
	
	int value = ageComparator.compare(emp1, emp2);
	System.out.println(value);
	
	System.out.println();
	
	ArrayList<Employee> arrayList = new ArrayList<>();
	arrayList.add(emp1);
	arrayList.add(emp2);
	
	for (Employee emp : arrayList) {
		System.out.println(emp);
	}
	
	
	
	}
	
	
}
