package com.kidob.sportgames.app.model.entity.sport;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kidob.sportgames.app.model.entity.base.AbstractEntity;

/**
 * Any sport club that contains our teams
 * 
 * @author Bogdan
 *
 */
@Entity
@Table(name = "Club", schema = "SportGames")
public class Club extends AbstractEntity{	
	
	@Column(name = "ClubName", nullable = false, length = 450)
	private String clubName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, 
			mappedBy = "club", orphanRemoval = true)
	private Set<Team> teams;
	
	public Club() {
	}

	public Club(String clubName) {
		this.setClubName(clubName);
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public Set<Team> getTeams() {
		return teams;
	}

	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}
}
