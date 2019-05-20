package com.kidob.sportgames.app.rest.dto;

import com.kidob.sportgames.app.model.entity.sport.Tournament;
import com.kidob.sportgames.app.rest.dto.base.BaseDTO;

/**
 * Holds Tournament state for the client-server communication
 * 
 * @author Bogdan
 *
 */
public class TournamentDTO extends BaseDTO<Tournament>{
	
	private String tournamentName;

	public String getTournamentName() {
		return tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}
	
}
