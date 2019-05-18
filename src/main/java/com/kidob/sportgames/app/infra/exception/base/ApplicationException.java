package com.kidob.sportgames.app.infra.exception.base;

/**
 * Base class for all application-specific exceptions
 * 
 * @author Bogdan
 *
 */
public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 7787504065945688185L;

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(Throwable throwable) {
		super(throwable);
	}

}
