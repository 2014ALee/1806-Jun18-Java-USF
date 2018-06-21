package com.revature;

import com.revature.models.Employee;

public class ThreadDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee emp1 = new Employee();
		emp1.setPriority(1);
		//emp1.run(); // does not actully create a new thread
		emp1.start(); // thread state: running
		
		/*
		 * using join(), we tell our thread to wait until the specified thread completw its execution.
		 */
		
		try {
			emp1.join();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		Employee emp2 = new Employee();
		emp2.setPriority(9);
		emp2.start();
		
		System.out.println(emp1.getPriority());
		System.out.println(emp2.getPriority());
		
		//Checking to see if given thread is alive or dead
		System.out.println(emp1.isAlive());
		System.out.println(emp2.isAlive());
	}

}
