package com.revature.util;
import java.io.FileNotFoundException;

import com.revature.models.Beta;
import com.revature.models.Circle;
import com.revature.models.Shape;

public class Charlie extends Beta {
	
	@Override
	public double protectedDoubleGetter() {
		return 5.5;
	}
	
	/*
	//cant override this because its in a different package so a default/package level modifier cant access it
	@Override
	String packageStringGetter() {
		return "nope";
	}
	*/
	
	/*//this works
	@Override
	public Shape getShape() {
		return new Shape();
	}
	*/
	
	//we can override a method by changing the return type of the method signature, but only if the new return type is a subclass of the original return type.
	@Override
	public Circle getShape() {
		return new Circle();
	}
	
	
	//you can override with a more specific exception but not with a more generic exception
	@Override
	protected String protectedStringThrowsException() throws FileNotFoundException {
		return "Method overriden";
	}
	
	/*
	 //this is invalid, because we are trying to override the inherited method by broadening the exception thrown
	@Override
	protected String protectedStringThrowsException() throws Exception {
		return "Method overridden";
	}
	*/
}
