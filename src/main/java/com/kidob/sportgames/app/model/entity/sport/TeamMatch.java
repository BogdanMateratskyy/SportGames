package com.kidob.sportgames.app.model.entity.sport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kidob.sportgames.app.model.entity.location.Place;

/**
 * Team points in one of the matches
 * 
 * @author Bogdan
 *
 */
@Entity
@Table (name = "TeamMatch", schema = "SportGames")
public class TeamMatch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column (name = "")
	private Long id;
	
	@ManyToOne
	@JoinColumn (name = "Match_ID", nullable = false)
	private Matches match;
	
	@ManyToOne
	@JoinColumn (name = "Team_ID", nullable = false)
	private Team team;
	
	@Column (name = "Score_Team_Match")
	private int scoreTeamMatch;
	
	@Column (name = "Place_ID")
	@Enumerated (EnumType.ORDINAL)
	private Place place;
	
	public TeamMatch() {
	}

	public TeamMatch(Matches match, Team team, int scoreTeamMatch, Place place) {
		this.match = match;
		this.team = team;
		this.scoreTeamMatch = scoreTeamMatch;
		this.place = place;
	}

	public Long getId() {
		return id;
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
