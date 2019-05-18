package com.kidob.sportgames.app.service;

import java.util.List;
import java.util.Optional;

import com.kidob.sportgames.app.model.entity.sport.Team;
import com.kidob.sportgames.app.rest.dto.TeamDTO;

/**
 *  Entry point to perform operations over club entities
 * 
 * @author Bogdan
 *
 */
public interface ClubService {
	
	/**
	 * Saves specified club instance
	 
	 * @param team
	 * @return the saved {@link Team} entity will never be null
	 */
	Team saveTeam(Team team);

	/**
	 * Updates specified club instance if exists
	 * 
	 * @param team
	 * @return
	 */
	Team updateTeam(TeamDTO team);

	/**
	 * Return list of existing clubs
	 * 
	 * @return
	 */
	List<Team> findTeams();

	/**
	 * Returns club with specified identifier. If club isn't found then empty
	 * optional is returned.
	 * 
	 * @param id
	 * @return
	 */
	Optional<Team> findTeamById(Long teamId);
}
