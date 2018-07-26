package com.revature.exceptions;

public class FlashCardNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FlashCardNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public FlashCardNotFoundException(String message) {
		super(message);
	}

	public FlashCardNotFoundException(Throwable cause) {
		super(cause);
	}

}
