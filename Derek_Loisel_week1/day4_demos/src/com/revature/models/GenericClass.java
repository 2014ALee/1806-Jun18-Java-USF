package com.revature.models;

public class GenericClass<T> {
	
//generic class typically used when you want similar funcitonality in a class but with different types, it can give you some more fluidity with what you can do.
	
	private T value;
	
	public T getValue() {
		return value;	
	}
		public void setValue(T t) {
			this.value = t;
		}
	
}
