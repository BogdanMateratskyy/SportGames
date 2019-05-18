package com.kidob.sportgames.app.rest.dto;

import com.kidob.sportgames.app.model.entity.sport.Club;
import com.kidob.sportgames.app.rest.dto.base.BaseDTO;

/**
 * Holds Club state for the client-server communication 
 * 
 * @author Bogdan
 *
 */
public class ClubDTO extends BaseDTO<Club> {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
