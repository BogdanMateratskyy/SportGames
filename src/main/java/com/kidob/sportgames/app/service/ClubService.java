package com.kidob.sportgames.app.service;

import java.util.List;
import java.util.Optional;

import com.kidob.sportgames.app.model.entity.sport.Club;

/**
 *  Entry point to perform operations over club entities
 * 
 * @author Bogdan
 *
 */
public interface ClubService {
	
	/**
	 * Saves specified club instance
	 
	 * @param club
	 * @return the saved {@link Club} entity will never be null
	 */
	Club saveClub(Club club);

	/**
	 * Updates specified club instance if exists
	 * 
	 * @param club
	 * @return
	 */
	Club updateClub(Club club);

	/**
	 * Return list of existing clubs
	 * 
	 * @return
	 */
	List<Club> findClubs();

	/**
	 * Returns club with specified identifier. If club isn't found then empty
	 * optional is returned.
	 * 
	 * @param clubId
	 * @return
	 */
	Optional<Club> findClubById(Long clubId);
}
