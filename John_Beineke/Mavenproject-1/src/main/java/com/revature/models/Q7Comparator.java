package com.revature.models;

import java.util.Comparator;

public class Q7Comparator implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		
		int a = 0;
		
		// with help from Derek
		// sort by name unless they are equal, then sort by department unless equal, then by age.
		a = emp1.getName().compareTo(emp2.getName());
		
		if(a == 0) {
			a = emp1.getDepartment().compareTo(emp2.getDepartment());
		}
		if(a == 0) {
			a = emp1.getAge().compareTo(emp2.getAge());
		}
		return 0;
	}
	
	
	
	

}
