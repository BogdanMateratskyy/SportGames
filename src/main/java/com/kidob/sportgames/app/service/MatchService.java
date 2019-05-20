package com.kidob.sportgames.app.service;

import java.util.List;
import java.util.Optional;

import com.kidob.sportgames.app.rest.dto.MatchDTO;

/**
 * Entry point to perform operations over match services
 * 
 * @author Bogdan
 *
 */
public interface MatchService {

	/**
	 * Saves specified data of match
	 * 
	 * @param matchDto
	 * @return
	 */
	MatchDTO saveMatch(MatchDTO matchDto);
	
	/**
	 * Update specified data of match if exists
	 * 
	 * @param matchDto
	 * @return
	 */
	MatchDTO updateMatch(MatchDTO matchDto);
	
	/**
	 * Returns list of existing matches
	 * 
	 * @return
	 */
	List<MatchDTO> findMatches();
	
	/**
	 * Returns data of match with specified identifier. If match isn't found then empty
	 * optional is returned.
	 * 
	 * @param matchId
	 * @return
	 */
	Optional<MatchDTO> findMatchById(Long matchId);
	
}
