package com.revature.models;
/*
 * The singleton pattern is implemented by creating a class with a method that creates
 * a new instance of the object IF one does not already exits. If an instance already
 * exists, it simply returns a reference to the object. To make sure that the object
 * cannot be instantiated in any other way, the constructor is made private.
 * 
 * Although a singleton can be implemented as a static instance, it can also be lazily
 * constructed, requiring no memory until needed.
 */

public class LazySingleton {
	
	/*
	 * This is just here to prove that changes to one reference to our LazySingleton
	 * instance are persisted across all references
	 */
	
	private int value;
	
	/*
	 * A static member of type LazySingleton will hold our one and only instance. It
	 * starts off as uninstantiated since we want to load it only when it is required.
	 */
	private static LazySingleton mySingleton;
	
	/*
	 * Making the constructor private ensures that it cannot be called outside of this class.
	 */
	private LazySingleton() { }
	
	//Public getter is used to fetch our one instance
	public static LazySingleton getInstance() {
		return (mySingleton == null) ? mySingleton = new LazySingleton() : mySingleton;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int num) {
		this.value = num;
	}
	
	/*
	 * We need to override the clone() so additional instances cannot be created.
	 */
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}
