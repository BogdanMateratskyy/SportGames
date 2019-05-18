package com.kidob.sportgames.app.rest.dto;

import com.kidob.sportgames.app.model.entity.sport.Club;
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
	
	private Club club;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}
}
