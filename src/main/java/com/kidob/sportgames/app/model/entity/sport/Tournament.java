package com.kidob.sportgames.app.model.entity.sport;

import com.kidob.sportgames.app.model.entity.base.AbstractEntity;

/**
 * Any kind of tournament 
 * 
 * @author Bogdan
 *
 */
public class Tournament extends AbstractEntity{
	private String name;

	public Tournament() {
	}

	public Tournament(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}
