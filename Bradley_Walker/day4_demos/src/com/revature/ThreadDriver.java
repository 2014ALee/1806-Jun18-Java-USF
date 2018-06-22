package com.revature;

import com.revature.models.Employee;

public class ThreadDriver {

	public static void main(String[] args) {
		Employee e1 = new Employee();	// Thread State: NEW
		e1.start();	// Creates a new thread. Thread State: RUNNING
//		e1.run();	// Doesn't actually create a new thread
		
		/*
		 * join() method
		 * 
		 * Wait until the specified thread completes its execution. There are overloaded versions
		 * which allow us to specify the time for which you want to wait for the specified thread
		 * to terminate.
		 */
		try {
			e1.join(); // waiting for e1 to finish its execution
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		Employee e2 = new Employee();
		e2.setPriority(9);	// More likely to run first
		e2.start();
		
		System.out.println(e1.isAlive());
		System.out.println(e2.isAlive());
	}

}
