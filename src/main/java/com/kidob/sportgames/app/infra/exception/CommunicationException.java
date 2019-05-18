package com.kidob.sportgames.app.infra.exception;

import com.kidob.sportgames.app.infra.exception.base.ApplicationException;

/**
 * Signals about exception cases in the work of external services and API
 * 
 * @author Bogdan
 *
 */
public class CommunicationException extends ApplicationException{

	private static final long serialVersionUID = 9059461161914471968L;

	public CommunicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommunicationException(String message) {
		super(message);
	}

}
