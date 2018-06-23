package com.revature.models;

/*
 * when we always need an instance or if instantiation doesn't take too many resources
 */


public class EagerSingleton {

	private int value;
	
	
	private static EagerSingleton mySingleton = new EagerSingleton();
	
	private EagerSingleton() {}
	
	public EagerSingleton getInstance(){
		return mySingleton;
	}
	
	public int getValue() {
		return value;
	}
	
}
