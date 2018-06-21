package com.revature;

public class ExceptionDriver {
	
	public static void main(String[] args) {
		
		System.out.println("This is the start of our program...");
		System.out.println("stufffff.....");
		
		try {
		Thread.sleep(5000);
		throw new InterruptedException();
		}catch (InterruptedException ie) { //the ie captures the throw so that we can go on to do an operation on it like printing/ getting output
			ie.printStackTrace();
		}finally {
			System.out.println("this is in the finally block");
//we can also throw errors like throw new OutOfMemoryError() but why would we want to cause errors in our program.
			//System.exit(0); will halt the app and nothing past this will be executed. Place this where you want your program to stop.
			
		}
		
		public static void throwSomething() throws Exception {
			
		}
		
	}

}
