package com.revature.models;

// Interface can extend multiple interface
public interface InterfaceB{
	
	void doSomething();
	
	default void doSomethingElse() {
		System.out.println("From the default methode");
	}
}
