package com.revature.models;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		char[] char1 = emp1.getName().toCharArray();
		char[] char2 = emp2.getName().toCharArray();
		for(int i = 0; i < char1.length; i++) {
			if(char1[i] < char2[i]) {
				return -1;
			} else if(char1[i] > char2[i]) {
				return 1;
			}
		}
		char1 = emp1.getDept().toCharArray();
		char2 = emp2.getDept().toCharArray();
		for(int i = 0; i < char1.length; i++) {
			if(char1[i] < char2[i]) {
				return -1;
			} else if(char1[i] > char2[i]) {
				return 1;
			}
		}
		if(emp1.getAge() < emp2.getAge()) {
			return -1;
		} else if(emp1.getAge() > emp2.getAge()) {
			return 1;
		} else {
			return 0;
		}
	}

}
