package com.kidob.sportgames.app.model.entity.sport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.kidob.sportgames.app.model.entity.base.AbstractEntity;

/**
 * Any kind of tournament 
 * 
 * @author Bogdan
 *
 */
@Entity
@Table (name = "Tournament", schema = "SportGames")
public class Tournament extends AbstractEntity{
	
	@Column (name = "TournamentName", length = 450)
	private String name;

	public Tournament() {
	}

	public Tournament(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}
