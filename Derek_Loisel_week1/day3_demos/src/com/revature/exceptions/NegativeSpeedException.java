package com.revature.exceptions;

public class NegativeSpeedException extends Exception	{

	private static final long serialVersionUID = 1L; //just add the default serial to get rid of warning
	
	public NegativeSpeedException()  {		
		//invoke parent constructor to get stacktrace
		super("cannot go a negative speed!");
	}

}
