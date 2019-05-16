package com.kidob.sportgames.app.model.entity.sport;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kidob.sportgames.app.model.entity.base.AbstractEntity;

/**
 * Competition between two or more teams in our tournaments
 * 
 * @author Bogdan
 *
 */
@Entity
@Table(name = "Matches", schema = "SportGames")
public class Matches extends AbstractEntity{
	
	@ManyToOne
	@JoinColumn(name = "SportID", nullable = false)
	private Sport sport;
	
	@ManyToOne
	@JoinColumn(name = "TournamentID", nullable = false)
	private Tournament tournament;
	
	@Column(name = "DateMatch", nullable = false)
	private LocalDateTime dateOfMatch;
	
	public Matches() {
	}

	public Matches(Sport sport, Tournament tournament, LocalDateTime dateOfMatch) {
		this.sport = sport;
		this.tournament = tournament;
		this.dateOfMatch = dateOfMatch;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public LocalDateTime getDateMatch() {
		return dateOfMatch;
	}

	public void setDateMatch(LocalDateTime dateOfMatch) {
		this.dateOfMatch = dateOfMatch;
	}
}
