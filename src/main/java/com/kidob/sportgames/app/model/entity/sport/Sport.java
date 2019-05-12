package com.kidob.sportgames.app.model.entity.sport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.kidob.sportgames.app.model.entity.base.AbstractEntity;

/**
 * The name of any kind of sport
 * 
 * @author Bogdan
 *
 */
@Entity
@Table (name = "Sport", schema = "SportGames")
public class Sport extends AbstractEntity {
	
	@Column (name = "SportName", nullable = false, length = 50)
	private String sportName;
	
	public Sport() {
	}
	
	public Sport(String sportName) {
		this.sportName = sportName;
	}
	
	public String getSportName() {
		return sportName;
	}
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
}
