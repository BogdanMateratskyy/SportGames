package com.kidob.sportgames.app.service;

import java.util.List;
import java.util.Optional;

import com.kidob.sportgames.app.model.entity.sport.Team;

/**
 * Entry point to perform operations over team entities
 * 
 * @author Bogdan
 *
 */
public interface TeamService {

	/**
	 * Saves specified team instance
	 * 
	 * @param team
	 */
	void saveTeam(Team team);

	/**
	 * Updates specified team instance if exists
	 * 
	 * @param team
	 * @return
	 */
	Team updateTeam(Team team);

	/**
	 * Return list of existing teams
	 * 
	 * @return
	 */
	List<Team> findTeams();

	/**
	 * Returns team with specified identifier. If team isn't found then empty
	 * optional is returned.
	 * 
	 * @param id
	 * @return
	 */
	Optional<Team> findTeamById(Long id);

	// List<Team> searchTeams();

	/**
	 * Delete specified team instance
	 * 
	 * @param TeamId
	 */
	void deleteTeam(Long TeamId);
}
