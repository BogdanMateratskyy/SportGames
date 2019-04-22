package com.kidob.sportgames.app.model.entity.sport;

import com.kidob.sportgames.app.model.entity.base.AbstractEntity;

/**
 * Any team/person which take part in a match
 * 
 * @author Bogdan
 *
 */
public class Team extends AbstractEntity{
	private String name;
	
	private Club club;
	
	public Team() {
	}
	public Team(String name) {
		this.name = name;
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
