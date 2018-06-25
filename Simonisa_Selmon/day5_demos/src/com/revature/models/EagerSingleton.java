package com.revature.models;

public class EagerSingleton {
	
	/* want to create when Eager instatntiation when the program will always need an instance.
	 * or if the cost of creating the instance os not too large in terms of time/resources, then we can use eager instantiation,
	 * which will alwyas creat an instance when the class is loaded into memory by the JVM.
	 */

	public class EagerSingleon {
		
		private int value;
		
		private static EagerSingleton mySingleton = new EagerSingleton();
		
		private EagerSingleton() { } 
		
		public static EagerSingleton getInstance() {
			
		}
		
		
		
	}
}
