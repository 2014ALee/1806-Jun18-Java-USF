package com.revature.models;

public class InterfaceImpl implements /*InterfaceA, //this is implied*/ InterfaceB{

	@Override
	public void doSomething() {
		System.out.println("do some stuff");
	}
	
	
	public void doSomethingCrazy(){
		
		System.out.println("doing something crazy");
	}
}
