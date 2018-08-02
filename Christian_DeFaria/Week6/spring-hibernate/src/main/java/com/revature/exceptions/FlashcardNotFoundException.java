package com.revature.exceptions;

public class FlashcardNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FlashcardNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public FlashcardNotFoundException(String message) {
		super(message);
	}

	public FlashcardNotFoundException(Throwable cause) {
		super(cause);
	}

}
