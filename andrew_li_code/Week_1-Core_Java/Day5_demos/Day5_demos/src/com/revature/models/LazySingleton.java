package com.revature.models;
/*
 * Although a Singleton can be implemented 
 * as a static instance,
 * it can also be lazily constructed.
 */
public class LazySingleton {
	/*
	 * This is just here to prove that changes to one
	 * reference to our Lazy Singleton instance are
	 * persisted across all references (since they
	 * refer to the same object)
	 */
	private int value;
	
	/*
	 * A static member of type LazySingleton will hold our one and
	 * only instance. It starts off as uninstantiated since
	 * we want to load it only when it is required (lazy-loading)
	 */
	private static LazySingleton mySingleton;
	
	private LazySingleton() {}
	
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
	 * We need to override the clone() method (inherited from Object)
	 * so that if it is invoked
	 * it will throw an exception. Otherwise, this method could be invoked to make a 
	 * copy of our singleton class - which defeats the purpose of his design
	 * pattern.
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
