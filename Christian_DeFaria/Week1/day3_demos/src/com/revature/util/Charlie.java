package com.revature.util;

import java.io.FileNotFoundException;

import com.revature.models.Beta;
import com.revature.models.Circle;
import com.revature.models.Shape;

public class Charlie extends Beta{
	
	@Override
	public double protectedDoubleGetter() {
		return 5.5;
	}
	
	//Methods with package level visibility are not inherited by subclasses in different package
//	@Override
//	String packageStringGetter() {
//		return "nope";
//	}
	
	/*
	 * This works! We can override a method by changing the return type of the method
	 * signature, but only ifthe new return type is a subclass of the original return
	 * type.
	 */
	@Override
	public Circle getShape() {
		return new Circle();
	}

	/*
	 * This does not work.
	 */
//	@Override
//	public Shape getCircle() {
//		return new Circle();
//	}
	
	@Override
	protected String protectedStringThrowsException() throws FileNotFoundException {
		return "";
	}
	
//	Not valid
//	@Override
//	public String publicStringThrowsAnIOException() throws Exception{
//		return "";
//	}
}
