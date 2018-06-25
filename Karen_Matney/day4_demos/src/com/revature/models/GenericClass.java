package com.revature.models;

/*
 * We can define our own classes with generic types. A generic type is a class or interface that
 * is parameterized over types. We use angle brackets to specify the parameter type
 */
public class GenericClass<T> {
	// The data type of these members will be whatever is specified at object instantiation
	private T value;
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T t) {
		this.value = t;
	}
}
