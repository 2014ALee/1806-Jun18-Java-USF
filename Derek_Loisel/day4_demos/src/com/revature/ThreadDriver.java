package com.revature;

import com.revature.models.Employee;

public class ThreadDriver {
	public static void main(String[] args) {

		Employee emp1 = new Employee(); // thread state:new
		// empl.run(); //doesnt actually create a new thread
		emp1.run(); // thread state:running
		emp1.setPriority(1);

		/*
		 * join() method
		 * 
		 * using join(), we tell our thread to wait until the specified thread completes
		 * its execution. there are overloaded versions of the join() method, which
		 * allows us to specify the time for which you want to wait for the specified
		 * thread to terminate
		 * 
		 * when called on a thread it says every other thread, stop, im gonna hog all
		 * the resources and your gonna wait for me to be done
		 */
		try {
			emp1.join();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

		Employee emp2 = new Employee();
		emp2.setPriority(9);
		emp2.start();
		
		System.out.println(emp1.getPriority());// prints threads priority
		System.out.println(emp2.isAlive());//checks if thread is alive
	}
}
