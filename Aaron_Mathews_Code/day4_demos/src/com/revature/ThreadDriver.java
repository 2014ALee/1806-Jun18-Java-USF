package com.revature;

import com.revature.models.Employee;

public class ThreadDriver {
	
	public static void main(String[] args) {
		
		Employee emp1 = new Employee();//Thread state: NEW
//		emp1.setPriority(1);
		emp1.start();//Thread state: RUNNING
		
		/*
		 * join()
		 * 
		 * Using join(), we tell the thread to wait until the specified thread completes its execution. There are overloaded versions of join()
		 * method, which allow us to specify the time for which you want to wait for the specified thread to terminate.
		 */
		try {
			emp1.join();//Waiting for emp1 to finish its execution
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Employee emp2 = new Employee();
//		emp2.setPriority(9);
		emp2.start();
		
		
	}

}
