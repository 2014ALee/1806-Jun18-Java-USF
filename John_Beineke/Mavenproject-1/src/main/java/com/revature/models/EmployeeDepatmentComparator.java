package com.revature.models;

public class EmployeeDepatmentComparator {
	
	public int compare(Employee emp1, Employee emp2) {
		if(emp1.getDepartment().compareTo(emp2.getDepartment()) < 0) {
			return -1;
		}
		else if(emp1.getDepartment().compareTo(emp2.getDepartment()) > 0) {
			return 1;
		}
		else {
				return -0;
			}
		}

}
