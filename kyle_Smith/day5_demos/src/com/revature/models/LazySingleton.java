package com.revature.models;

public class LazySingleton {

	/*
	 * This is just here to prove that changes to one reference to our LazySingleton
	 * instance are persisted across all references (since they refer to the same object)
	 */
	private int value;
	
	/*
	 *  A static member of type LazySingleton will hold our one and only instance. It starts
	 *  off as uninstantiated since we want to laod it only when it is required (lazy-loading)
	 */
	//this is what makes it lazy
	private static LazySingleton mySingleton;
	
	/*
	 * Making the constructor private ensures that it cannot be called outside of this class.
	 */
	private LazySingleton() {}
	
	//this public getter method is what is used to fetch our one and only instance
	public static LazySingleton getInstance() {
		
		/*
		 * If the static member 'mySingleton' is null, instantiate a new LazySingleton object
		 * and return it. Otherwise, just return the existing instance.
		 */
		return (mySingleton == null) ? mySingleton = new LazySingleton() : mySingleton;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int num) {
		this.value = num;
	}
	
	/*
	 * We need to override the clnoe() method (inherited from Object) sot hat if it is invoked
	 * it will throw an exception. Otherwise, this method could be invoked to make a copy of our 
	 * singleton class- which defeats the purpose of this design pattern.
	 */
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
