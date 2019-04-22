package com.kidob.sportgames.app.model.entity.sport;

import javax.persistence.Entity;
import com.kidob.sportgames.app.model.entity.location.Place;

/**
 * Team points in one of the matches
 * 
 * @author Bogdan
 *
 */
@Entity
public class TeamMatch {
	private Matches match;
	private Team team;
	private int scoreTeamMatch;
	private Place place;
	
	public TeamMatch() {
	}

	public TeamMatch(Matches match, Team team, int scoreTeamMatch, Place place) {
		this.match = match;
		this.team = team;
		this.scoreTeamMatch = scoreTeamMatch;
		this.place = place;
	}

	public Matches getMatch() {
		return match;
	}

	public void setMatch(Matches match) {
		this.match = match;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getScoreTeamMatch() {
		return scoreTeamMatch;
	}

	public void setScoreTeamMatch(int scoreTeamMatch) {
		this.scoreTeamMatch = scoreTeamMatch;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}	
	
}
