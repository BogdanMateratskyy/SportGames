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
	
	/**
	 * Should be overridden in the derived classes if additional transformation
	 * logic domain model -> DTO is needed. Overridden methods should call
	 * super.transform()
	 */
	public void transform(T t) {
		id = t.getId();
	}

	/**
	 * Should be overridden in the derived classes if additional transformation
	 * logic DTO -> domain model is needed
	 */
	public T untransform(T t) {
		t.setId(getId());
		return t;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
