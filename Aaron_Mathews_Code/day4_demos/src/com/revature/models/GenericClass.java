package com.revature.models;

/*
 * Define classes with generic types
 * Generic type is a class or interface tht is parameterized over types
 * We use the angle brackets to specify the parameter type.
 */

public class GenericClass<T> {
	//Data type of this members will be whatever is specified at object instantiation
	private T value;
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T t) {
		this.value = t;
	}
}
