package com.revature.models;

/*
 * The singleton pattern is implemented by creating the class with a method that
 * creates a new instance of the object if one doesn't exist. If it exists, 
 * it returns a reference to that object. To make sure that the object cannot be
 * instantiated any other way, the constructor is made private.
 * 
 * Although a singleton can be implemented as a static instance, it can also be
 * lazily constructed, requiring no memory or resources until needed.
 */

public class LazySingleton {
	
	/*
	 * This is here to prove that changes to one reference of our lazy singleton
	 * are persisted across all references.
	 */
	private int value;
	
	/*
	 * A static member of type LazySingleton will hold the only instance. Lazy
	 * because it isn't instantiated until it is asked for.
	 */
	private static LazySingleton mySingleton;
	
	/*
	 * Making the constructor private ensures that it cannot be called outside of
	 * this class.
	 */
	private LazySingleton() {}
	
	public static LazySingleton getInstance() {
		return (mySingleton == null) ? mySingleton = new LazySingleton() : mySingleton;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	// If it isn't overridden, this method defeats the purpose of using the singleton pattern
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}
