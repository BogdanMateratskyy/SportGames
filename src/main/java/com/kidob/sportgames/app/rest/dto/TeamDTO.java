package com.kidob.sportgames.app.rest.dto;

import com.kidob.sportgames.app.model.entity.sport.Team;
import com.kidob.sportgames.app.rest.dto.base.BaseDTO;

/**
 * Holds Team state for the client-server communication
 * 
 * @author Bogdan
 *
 */
public class TeamDTO extends BaseDTO<Team> {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
