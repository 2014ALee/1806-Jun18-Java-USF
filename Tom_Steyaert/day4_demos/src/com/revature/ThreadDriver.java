package com.revature;

import com.revature.models.Employee;

public class ThreadDriver {

	public static void main(String[] args) {
		
		Employee emp1 = new Employee();
	//	emp1.run(); does not actually create a new thread
		emp1.setPriority(1);
		emp1.start(); //thread state: RUNNING
		
		/*
		 * Using join we tell our thread to wait until the specified thread completes it's
		 * execution. There are overloaded versions of the join method, which allows us to specify the time for which you
		 * want to wait for the specified thread to terminate
		 */
		
		//the default priority is 5
		
			try {
				emp1.join();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} //waiting for emp1 to finish it's execution
		
		
		Employee emp2 = new Employee();
		emp2.setPriority(9);
		emp2.start();
		
	}
	
	
}
