package com.revature.models;

import java.util.Comparator;

public class EmployeeAgeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		
		if((emp1.getAge() - emp2.getAge() < 0))
			return -1;
		
		else if (emp1.getAge() - emp2.getAge() > 0)
			return 1;
		
		else
			return 0;		
	}
}
