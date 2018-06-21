package com.revature.models;

public interface InterfaceA { //interfaces are implicitly abstract

	int MY_INT= 35;
	
	void doSomethingElse() {
		
		default void 
		System.out.println("InterfaceA is doing something else...");
	}
	
}
