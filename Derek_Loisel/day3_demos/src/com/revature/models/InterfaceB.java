package com.revature.models;


/*
 * interfaces can extend one another, and even extend multiple interfaces
 */

public interface InterfaceB extends InterfaceA{
	
	void doSomething();
	
	@Override
	default void doSomethingElse() {
		System.out.println("InterfaceB is doing something else...");
	}
}
