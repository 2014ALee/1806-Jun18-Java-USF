package com.revature.models;

public class GenericClass<T> {

	private T value;
	
	public T getValue() {
		return value;
	}
	
	
	public void setValue (T t) {
		this.value = t;
	}
	
	//we can define our own classes with generic types
	//a generic type is a class or interface that is parameterized over types.
	
	
}
