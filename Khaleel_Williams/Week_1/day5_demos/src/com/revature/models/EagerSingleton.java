package com.revature.models;

/*
 * If the program will always need an instance, or if the cost o creating 
 * the instance is not too large in terms of time/resources, then we can use eager-instantiation,
 * which always creates an instance when the class is loaded into memory by the 
 * JVM.
 */

public class EagerSingleton {
	
	private int value;
	
	private static EagerSingleton mySingleton = new EagerSingleton();
	
	private EagerSingleton() { }
	
	public static EagerSingleton getInstance() {
		return mySingleton;
	}
	
	public int getValue() {
		return value;
	}
	
	
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public void setValue(int i) {
		// TODO Auto-generated method stub
		this.value = i;
	}
}
