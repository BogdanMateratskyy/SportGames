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
	
	private String teamName;
	
	private Long clubId;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Long getClubId() {
		return clubId;
	}

	public void setClubId(Long clubId) {
		this.clubId = clubId;
	}

}
