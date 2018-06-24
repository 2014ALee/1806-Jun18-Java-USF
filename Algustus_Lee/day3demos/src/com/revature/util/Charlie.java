package com.revature.util;

import java.io.FileNotFoundException;

import com.revature.models.Beta;
import com.revature.models.Circle;
import com.revature.models.Shape;

public class Charlie extends Beta{
	@Override
	public double protectedDoubleGetter()
	{
		return 5.5d;
	}
	
	/*
	 * Methods with package-level visibility are not inherited by subclasses located in a different package.
	 */
	
	/*
	 * This works!
	 * We can override a method by changing the return type of the method signature, but only if the new return type is
	 * a subclass of the original return type
	 */
	@Override
	public Circle getShape()
	{
		return new Circle();
	}
	
	/*
	 * This does not work.
	 * We are trying to override the method by using a superclass of the return type instead of a subclass.
	 */
	//@Override
	//public Shape getCircle()
	//{
	//	return new Circle();
	//}
	
	
	@Override	
	protected String protectedStringThrowsException() throws FileNotFoundException
	{
		return "Overridden";
	}	
	
	//@Override
	//public String publicStringThrowsIOException() throws Exception{
	//	return "Overridden";
	//}
	/*Override rules, throws and exceptions: It is valid to throw something more specific with a general throw, you cannot
	 * make it less specific. You can also remove the throw expression alltogether. If it doesn't have a throw clause 
	 * before you override it, you cannot add one.
	 */
}
