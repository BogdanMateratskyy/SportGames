package com.kidob.sportgames.app.model.entity.location;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Place of the match that we support in the application 
 * 
 * @author Bogdan
 * 
 */
public class Place {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "PlaceID")
	private int id;
	
	@Column (name = "PlaceName", nullable = false)
	private String name;

	public Place() {
	}
	
	public Place(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
