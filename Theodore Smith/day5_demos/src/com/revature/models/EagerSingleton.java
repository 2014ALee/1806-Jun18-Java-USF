package com.revature.models;

public class EagerSingleton {
	
	private int value;
	
	private static EagerSingleton mySingleton = new EagerSingleton();
	
	private EagerSingleton() {
		
	}
	public static EagerSingleton getInstance() {
		return mySingleton;
	}
	
}
