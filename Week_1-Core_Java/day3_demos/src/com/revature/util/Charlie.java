package com.revature.util;

import java.io.FileNotFoundException;

import com.revature.models.Beta;
import com.revature.models.Circle;

public class Charlie extends Beta {
	
	@Override
	public double protectedDoubleGetter() {
		return 5.5;
	}
	
	/* 
	 * Methods with package-level visibility are not inherited by subclasses located
	 * in a different package.
	 */
//	@Override
//	String packageStringGetter() {
//		return "nope";
//	}
	
	/*
	 * This works! We can override a method by changing the return type of the method
	 * signature, but only if the new return type is a subclass of the original return
	 * type.
	 */
	@Override
	public Circle getShape() {
		return new Circle();
	}
	
	/*
	 * This does not work, because we are trying to override the method by using a super
	 * class of the return type, instead of a subclass.
	 */
//	@Override
//	public Shape getCircle() {
//		return new Circle();
//	}
	
	/*
	 * This is valid, because we are overriding the method by throwing a more specific
	 * type of exception.
	 */
	@Override
	protected String protectedStringThrowsException() throws FileNotFoundException {
		return "Method overridden";
	}
	
	/*
	 * This is invalid, because we are trying to override the inherited method by broadening
	 * the exception thrown.
	 */
//	@Override
//	public String publicStringThrowsIOException() throws Exception {
//		return "";
//	}

}
