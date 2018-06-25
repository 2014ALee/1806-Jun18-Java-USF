package com.revature;

import com.revature.models.Employee;

public class ThreadDriver {

	public static void main(String[] args) {
		
		Employee emp1 = new Employee();		// Thread state: NEW
//		emp1.run();			// does not actually create a new thread
		emp1.setPriority(1);
		emp1.start();		// Thread state: RUNNING
		
		/*
		 * join() method
		 * 
		 * Using join(), we tell our thread to wait until the specified thread completes
		 * its execution. There are overloaded versions of the join() method, which allow
		 * us to specify the time for which you want to wait for the specified thread
		 * to terminate
		 */
		
		try {
			emp1.join(); 		// Waiting for emp1 to finish its execution
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		
		Employee emp2 = new Employee();
		emp2.setPriority(9);
		emp2.start();
		
		/*
		 * Display the priority of threads. the default priority is 5
		 */
		
		System.out.println(emp1.getPriority());
		System.out.println(emp2.getPriority());
		
		/*
		 * check to see if thread is alive or dead
		 */
		
		System.out.println(emp1.isAlive());
		System.out.println(Thread.currentThread().isAlive());
	}
}
