package com.kidob.sportgames.app.infra.exception;

import com.kidob.sportgames.app.infra.exception.base.ApplicationException;

/**
 * Signals about incorrect configuration settings/parameters
 * 
 * @author Bogdan
 *
 */
public class ConfigurationException extends ApplicationException{

	private static final long serialVersionUID = 1290992379258413148L;

	public ConfigurationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConfigurationException(String message) {
		super(message);
	}

	public ConfigurationException(Throwable throwable) {
		super(throwable);
	}

}
