package com.kidob.sportgames.app.infra.exception;

import com.kidob.sportgames.app.infra.exception.base.ApplicationException;

/**
 * Signals about exceptional cases in the application logic
 * 
 * @author Bogdan
 *
 */
public class FlowException extends ApplicationException{

	private static final long serialVersionUID = 4181566901277451522L;

	public FlowException(String message, Throwable cause) {
		super(message, cause);
	}

	public FlowException(String message) {
		super(message);
	}

}
