package com.revature.models;

public class GenericClass<T> {
	
	private T value;
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T t) {
		this.value = t;
	}
}
