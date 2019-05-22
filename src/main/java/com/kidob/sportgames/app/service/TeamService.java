package com.kidob.sportgames.app.service;

import java.util.List;
import java.util.Optional;

import com.kidob.sportgames.app.model.entity.sport.Team;
import com.kidob.sportgames.app.rest.dto.TeamDTO;

/**
 * Entry point to perform operations over team entities
 * 
 * @author Bogdan
 *
 */
public interface TeamService {

	/**
	 * Saves specified team instance
	 
	 * @param team
	 * @return the saved {@link Team} entity will never be null
	 */
	TeamDTO saveTeam(TeamDTO team);

	/**
	 * Updates specified team instance if exists
	 * 
	 * @param team
	 * @return
	 */
	TeamDTO updateTeam(TeamDTO teamDto);

	/**
	 * Return list of existing teams
	 * 
	 * @return
	 */
	List<TeamDTO> findTeams();

	/**
	 * Returns team with specified identifier. If team isn't found then empty
	 * optional is returned.
	 * 
	 * @param id
	 * @return
	 */
	Optional<TeamDTO> findTeamById(Long teamId);

	// List<Team> searchTeams();

	/**
	 * Delete specified team instance
	 * 
	 * @param TeamId
	 */
	boolean deleteTeam(Long teamId);
}
