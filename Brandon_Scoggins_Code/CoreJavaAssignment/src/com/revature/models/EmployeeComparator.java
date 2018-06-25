package com.revature.models;
// Question 7
import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {

		if(emp1.getName().compareToIgnoreCase(emp2.getName()) > 0) 
			return 1;
		else if(emp1.getName().compareToIgnoreCase(emp2.getName()) < 0)
			return -1;
		else 
			return compareDepartment(emp1, emp2);
	}

	public int compareDepartment(Employee emp1, Employee emp2) {
		if(emp1.getDepartment().compareToIgnoreCase(emp2.getDepartment()) > 0) 
			return 1;
		else if(emp1.getDepartment().compareToIgnoreCase(emp2.getDepartment()) < 0)
			return -1;
		else
			return compareAge(emp1, emp2);
	}
	
	public int compareAge(Employee emp1, Employee emp2) {
		if(emp1.getAge() > emp2.getAge()) 
			return 1;
		else if(emp1.getAge() < emp2.getAge()) 
			return -1;
		else
			return 0;
	}
}
