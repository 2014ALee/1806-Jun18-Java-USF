package com.revature.models;

public class GenericClass<T> {
	/*
	 * We can define our own classes with generic types. A generic type is a class or interface that is
	 * parameterized over types. We use anglebrackets to specify the parameter type.
	 */
	
	private T value;
	
	//The data type of these members will be whatever is specified at object instantiation.
	public T getValue()
	{
		return value;
	}
	
	public void setValue(T t)
	{
		this.value = t;
	}
	

}
