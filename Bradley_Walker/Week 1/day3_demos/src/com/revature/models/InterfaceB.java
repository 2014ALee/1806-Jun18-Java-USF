package com.revature.models;

/*
 * Interfaces can extend each other and can extend multiple interfaces.
 */

public interface InterfaceB extends InterfaceA {
	
	void doSomething();
	
	@Override
	default void doSomethingElse() {
		System.out.println("InterfaceB is doing something else");
	}

}
