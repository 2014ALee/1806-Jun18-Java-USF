package com.revature;

import com.revature.models.Employee;

public class ThreadDriver {
	public static void main(String[] args)
	{
		Employee emp1 = new Employee();//Thread state: NEW
		//emp1.run(); does not actually create a new thread
		emp1.start(); //Thread state: RUNNING
		
		Employee emp2 = new Employee();
		emp2.setPriority(9);
		emp2.start();
		/*
		 * join() method
		 * 
		 * Using join(), we tell our thread to wait until the specified thread completes its execution.
		 * There we are overloaded versions of the join() method, which allows us to specify the time for which you
		 * want to wait for the specified thread to terminate.
		 */
		
		try {
			emp1.join();// waiting for emp1 to finish its execution
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		//display the priority of threads. the default priority is 5.
		System.out.println(emp1.getPriority());
		System.out.println(emp2.getPriority());
		
		//check to see if a given thread is alive or dead
		System.out.println(emp1.isAlive());
		System.out.println(emp2.isAlive());
		
		System.out.println(emp1.getPriority());
		System.out.println(emp2.getPriority());
	}
	

}
