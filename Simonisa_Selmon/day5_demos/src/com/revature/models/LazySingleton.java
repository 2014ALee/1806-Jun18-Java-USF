package com.revature.models;

import com.revature.$missing$;

public class LazySingleton {
	
	//there are multiple ways to implement the Singleton Design Pattern
	
	/*Types
	 * Lazy loading 
	 * Eager Loading
	 * 
	 * These are features of the Singleton Design Pattern.
	 * 
	 * They can also be thread safe and non-thread safe.
	 * 
	 * The Singleton pattern is implemented by creating a class with a method that creates 
	 * a new instance of the obhect IF one does not already exist. If an instance 
	 * already exists, it simply returns a reference to that object. 
	 * 
	 * To make sure that the obgect cannot be instantiated in aany other way the constructor is 
	 * made PRIVATE.
	 * 
	 * Although Singleton can be impleemnted as a static instance, it can also be 
	 * lazily sonstructed requiring no memory or resources until needed
	 */
	
	private int value;
	/*
	 * the is just here to prove that changes to one refernece to our LAzy singleton
	 * instance are persisted afross all references(since they refer to the same object)
	 */

	private static LazySingleton mySingleton;
	/*
	 * a static member of type lazy will hold our one and only instance. 
	 * It starts off as uninstantiated since we wnat to load it on ly with is required.
	 */
	
	private static LazySingleton() {}
	//making the constructor private ensure that it cannot be called ourside of this class.
	
	public static LazySingleton getInstance() {
		//this getter method is what is used to fetch out one and only instance
		
		return(mySingleton ==null) ? mySingleton = new LazySingleton() : mySingleton;
		
	/*if the static member 'mySingleton is null, instantiate a new LaxySingleton object and return it.
	 * Otherwise, just return the existing instance
	 * 
	 * this is the only line of code that will create a new instance of it*
	 * 
	 * we cannot make a new one using he new keyword because its has private method!
	 */
		
		public int getValue() {
			return value;
			
		}
		
		public void setValue(int num ) {
			this.value = num;
		}
		
		//override this
		public Object clone() throws CloneNotSupportedException {
			throw new CloneNotSupportedException();
		}
	}
}

}
