package com.kidob.sportgames.app.service;

import java.util.List;
import java.util.Optional;

import com.kidob.sportgames.app.model.entity.sport.Tournament;
import com.kidob.sportgames.app.rest.dto.TournamentDTO;

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
	TournamentDTO saveTournament(TournamentDTO tournamentDto);

	/**
	 * Return list of existing tournaments
	 * 
	 * @return
	 */
	List<TournamentDTO> findTournaments();

	/**
	 * Returns tournament with specified identifier. If tournament isn't found then empty
	 * optional is returned.
	 * 
	 * @param tournamentId
	 * @return
	 */
	Optional<TournamentDTO> findTournamentById(Long tournamentId);
}
