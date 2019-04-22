package com.kidob.sportgames.app.model.entity.sport;

import com.kidob.sportgames.app.model.entity.base.AbstractEntity;

/**
 * The name of any kind of sport
 * 
 * @author Bogdan
 *
 */
public class Sport extends AbstractEntity {
	
	private String sportName;
	
	public Sport() {
	}
	
	public Sport(String sportName) {
		this.sportName = sportName;
	}
	
	public String getSportName() {
		return sportName;
	}
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
}
