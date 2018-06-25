package com.revature.models;

public class LazySingleton {

	private int value;
	
	private static LazySingleton mySingleton;
	
	
	

	private LazySingleton() {}
	
	public static LazySingleton getInstance() {
		return (mySingleton == null) ? mySingleton = new LazySingleton() : mySingleton;	}
}
