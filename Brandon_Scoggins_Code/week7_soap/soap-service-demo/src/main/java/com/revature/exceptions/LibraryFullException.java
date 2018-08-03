package com.revature.exceptions;

public class LibraryFullException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public LibraryFullException() {
		super();
	}
	
	public LibraryFullException(String message) {
		super(message);
	}

}
