package com.revature.models;

// Note: InterfaceB wasn't extending InterfaceA, and a naming collision occurred
public class InterfaceImpl implements InterfaceA, InterfaceB {

	// Which interface is this inheriting from?
	@Override
	public void doSomething() {
		System.out.println("Do some stuff...");
	}
}