package com.kidob.sportgames.app.service;

import java.util.List;
import java.util.Optional;

import com.kidob.sportgames.app.model.entity.sport.Sport;

/**
 * Entry point to perform operations over sport entities
 * 
 * @author Bogdan
 *
 */
public interface SportService {

	/**
	 * Saves specified sport instance
	 * 
	 * @param sport
	 * @return the saved {@link Sport} entity will never be null
	 */
	Sport saveSport(Sport sport);

	/**
	 * Return list of existing sports
	 * 
	 * @return
	 */
	List<Sport> findSports();

	/**
	 * Returns sport with specified identifier. If sport isn't found then empty
	 * optional is returned.
	 * 
	 * @param sportId
	 * @return
	 */
	Optional<Sport> findSportById(Long sportId);
}
