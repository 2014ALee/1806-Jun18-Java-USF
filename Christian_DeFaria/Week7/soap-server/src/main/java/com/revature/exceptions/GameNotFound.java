package com.revature.exceptions;

public class GameNotFound extends Exception {

	private static final long serialVersionUID = 1L;
	
	public GameNotFound() {
		super();
	}
	
	public GameNotFound(String message) {
		super(message);
	}

}
