package com.revature.models;

public class EmployeeNameComparator {
	
	public int compare(Employee emp1, Employee emp2) {
		if(emp1.getName().compareTo(emp2.getName()) < 0) {
			return -1;
		}
		else if(emp1.getName().compareTo(emp2.getName()) > 0) {
			return 1;
		}
		else {
				return -0;
			}
		}

}
