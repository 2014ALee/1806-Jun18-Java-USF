package com.revature;

import com.revature.models.Employee;

public class ThreadDriver {

	public static void main(String[] args) {
		
		Employee emp1 = new Employee();
	//	emp1.run(); does not actually create a new thread
		emp1.setPriority(1);
		emp1.start(); //thread state: RUNNING
		
		Employee emp2 = new Employee();
		emp2.setPriority(9);
		emp2.start();
		
	}
	
	
}
