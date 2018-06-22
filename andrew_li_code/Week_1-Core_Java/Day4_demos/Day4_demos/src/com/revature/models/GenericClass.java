package com.revature.models;

public class GenericClass<T> {
	// The data type of these members will be whatever is specified at object instantiation.
	private T value;
	
	public T getValue() {
		return value;
	}
	public void setValue(T t) {
		this.value = t;
	}
}
