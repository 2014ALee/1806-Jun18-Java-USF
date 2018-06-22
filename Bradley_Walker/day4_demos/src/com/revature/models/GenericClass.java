package com.revature.models;

/*
 * We can define out own classes with generic types. A generic type is a class or interface
 * that is parameterized over types.
 */

public class GenericClass<T> {
	
	private T value;
	
	public T getValue() {
		return this.value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}

}
