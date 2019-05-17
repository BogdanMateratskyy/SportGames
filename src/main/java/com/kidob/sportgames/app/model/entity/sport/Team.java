package com.kidob.sportgames.app.model.entity.sport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kidob.sportgames.app.model.entity.base.AbstractEntity;

/**
 * Any team/person which take part in a match
 * 
 * @author Bogdan
 *
 */
@Entity
@Table(name = "Team", schema = "SportGames")
public class Team extends AbstractEntity {

	@Column(name = "TeamName", nullable = false, length = 450)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "ClubId")
	private Club club;

	public Team() {
	}

	public Team(String name, Club club) {
		this.name = name;
		this.club = club;
	}

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
