package com.kidob.sportgames.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidob.sportgames.app.infra.exception.PersistenceException;
import com.kidob.sportgames.app.model.entity.sport.Team;
import com.kidob.sportgames.app.persistence.repository.TeamRepository;
import com.kidob.sportgames.app.service.TeamService;

/**
 * Default implementation of the {@link TeamService}
 * 
 * @author Bogdan
 *
 */
@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository teamRepository;

	@Override
	public Team saveTeam(Team team) {
		return teamRepository.save(team);
	}

	@Override
	public Team updateTeam(Team team) {
		Team checkedTeam = teamRepository.findById(team.getId())
				.orElseThrow(() -> new PersistenceException("Team not found"));	
		
		return teamRepository.saveAndFlush(checkedTeam);
	}

	@Override
	public List<Team> findTeams() {
		return teamRepository.findAll();
	}

	@Override
	public Optional<Team> findTeamById(Long teamId) {
		return teamRepository.findById(teamId);
	}

	@Override
	public void deleteTeam(Long teamId) {
		teamRepository.deleteById(teamId);
	}

}
