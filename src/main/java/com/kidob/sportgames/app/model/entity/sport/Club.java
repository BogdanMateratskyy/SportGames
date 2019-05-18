package com.kidob.sportgames.app.model.entity.sport;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Club extends AbstractEntity {

	@Column(name = "Club_Name", nullable = false, length = 450)
	private String clubName;

	public Club() {
	}

	public Club(String clubName) {
		this.clubName = clubName;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
}
