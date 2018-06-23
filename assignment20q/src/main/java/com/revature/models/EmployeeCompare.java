package com.revature.models;

import java.util.Comparator;

public class EmployeeCompare implements Comparator<Employee>{

	@Override 
	public int compare(Employee emp1, final Employee emp2) {
	    int c;
	    c = emp1.getName().compareTo(emp2.getName());
	    if (c == 0)
	       c = emp1.getAge().compareTo(emp2.getAge());
	    if (c == 0)
	       c = emp1.getDepartment().compareTo(emp2.getDepartment());
	    return c;
	}
}
