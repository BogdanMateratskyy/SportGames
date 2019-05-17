package com.kidob.sportgames.app.rest.dto.base;

import com.kidob.sportgames.app.model.entity.base.AbstractEntity;

/**
 * Base class for all DTO classes
 * 
 * @author Bogdan
 *
 */
public class BaseDTO <T extends AbstractEntity>{

	/**
	 * Unique entity identifier
	 */
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
