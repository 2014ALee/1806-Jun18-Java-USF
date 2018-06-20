package com.revature;

import.IO.Exception;
public class ExceptionDriver {

	public static void main(String[] args) {
		
		System.out.println("This is the start of our program...");
		System.out.println("Stuff...");
		
		try {
		Thread.sleep(5000);
		throw new InterruptedException();
		// throw new OutOfMemoryError();
		// System.exit(0);
		
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} finally {
			System.out.println(" This is in the finaally block");
		}
		System.out.println("This is after te try/catchfinally blocks.");
	}
		public static void throwSomething() throws IOException{
			System.out.println("This method might throw an exception");
		}
	}

}
