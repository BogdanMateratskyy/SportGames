package com.kidob.sportgames.app.infra.exception;

import com.kidob.sportgames.app.infra.exception.base.ApplicationException;

/**
 * Signals about data access layer unexpected situation
 * 
 * @author Bogdan
 *
 */
public class PersistenceException extends ApplicationException {

	private static final long serialVersionUID = 4853778545210911722L;

	public PersistenceException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public PersistenceException(String message) {
		super(message);
	}
}
