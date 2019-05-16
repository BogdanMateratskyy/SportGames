package com.kidob.sportgames.app.model.search.criteria;

import com.kidob.sportgames.app.model.entity.sport.Club;

/**
 * Filtering criteria for search teams operation
 * 
 * @author Bogdan
 *
 */
public class TeamCriteria {

	/**
	 * Club's name
	 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
