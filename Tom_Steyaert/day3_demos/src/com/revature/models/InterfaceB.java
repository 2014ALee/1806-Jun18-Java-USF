package com.revature.models;

public interface InterfaceB extends InterfaceA {

//interfaces can extend one another and even multiple interfaces if desired
//in this case we will need to extend interfaceA 
	
	void doSomething();
	
	default void doSomethingElse() {
		System.out.println("InterfaceB is doing something else");
	}
	
	
}
