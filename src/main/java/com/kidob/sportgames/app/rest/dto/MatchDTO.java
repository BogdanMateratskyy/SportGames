package com.kidob.sportgames.app.rest.dto;

import com.kidob.sportgames.app.model.entity.sport.Matches;
import com.kidob.sportgames.app.rest.dto.base.BaseDTO;

/**
 * Holds Matches and TeamMatche state for the client-server communication.
 * 
 * @author Bogdan
 *
 */
public class MatchDTO extends BaseDTO<Matches>{

	private Long sportId;	
	private Long tournamentId;	
	private Long homeTeamId;
	private Long awayTeamId;
	private int homeTeamScore;	
	private int awayTeamScore;
	
	public Long getSportId() {
		return sportId;
	}
	public void setSportId(Long sportId) {
		this.sportId = sportId;
	}
	public Long getTournamentId() {
		return tournamentId;
	}
	public void setTournamentId(Long tournamentId) {
		this.tournamentId = tournamentId;
	}
	public Long getHomeTeamId() {
		return homeTeamId;
	}
	public void setHomeTeamId(Long homeTeamId) {
		this.homeTeamId = homeTeamId;
	}
	public Long getAwayTeamId() {
		return awayTeamId;
	}
	public void setAwayTeamId(Long awayTeamId) {
		this.awayTeamId = awayTeamId;
	}
	public int getHomeTeamScore() {
		return homeTeamScore;
	}
	public void setHomeTeamScore(int homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}
	public int getAwayTeamScore() {
		return awayTeamScore;
	}
	public void setAwayTeamScore(int awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}
}
