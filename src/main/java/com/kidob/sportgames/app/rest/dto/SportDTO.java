package com.kidob.sportgames.app.rest.dto;

import com.kidob.sportgames.app.model.entity.sport.Sport;
import com.kidob.sportgames.app.rest.dto.base.BaseDTO;

/**
 * Holds Sport state for the client-server communication
 * 
 * @author Bogdan
 *
 */
public class SportDTO extends BaseDTO<Sport> {

	private String sportName;
	
	public String getSportName() {
		return sportName;
	}
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
}
