package com.kidob.sportgames.app.service;

import java.util.List;
import java.util.Optional;

import com.kidob.sportgames.app.model.entity.sport.Tournament;

/**
 * Entry point to perform operations over tournament entities
 * 
 * @author Bogdan
 *
 */
public interface TournamentService {

	/**
	 * Saves specified tournament instance
	 * 
	 * @param tournament
	 * @return the saved {@link Tournament} entity will never be null
	 */
	Tournament saveTournament(Tournament tournament);

	/**
	 * Return list of existing tournaments
	 * 
	 * @return
	 */
	List<Tournament> findTournaments();

	/**
	 * Returns tournament with specified identifier. If tournament isn't found then empty
	 * optional is returned.
	 * 
	 * @param tournamentId
	 * @return
	 */
	Optional<Tournament> findTournamentById(Long tournamentId);
}
