package com.revature.models;

public interface InterfaceA {
	
	public static final int MY_INT = 35;
	
	public abstract void doSomething();
	
	default void doSomethingElse() {
		System.out.println("InterfaceA is doing something else...");
	}
		
}
