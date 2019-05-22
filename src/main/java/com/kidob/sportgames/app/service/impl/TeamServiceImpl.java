package com.kidob.sportgames.app.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidob.sportgames.app.infra.exception.PersistenceException;
import com.kidob.sportgames.app.model.entity.sport.Club;
import com.kidob.sportgames.app.model.entity.sport.Team;
import com.kidob.sportgames.app.persistence.repository.ClubRepository;
import com.kidob.sportgames.app.persistence.repository.TeamRepository;
import com.kidob.sportgames.app.rest.dto.TeamDTO;
import com.kidob.sportgames.app.service.TeamService;

/**
 * Default implementation of the {@link TeamService}
 * 
 * @author Bogdan
 *
 */
@Service
public class TeamServiceImpl implements TeamService {

	ModelMapper modelMaper = new ModelMapper();
	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private ClubRepository clubRepository;

	@Override
	public TeamDTO saveTeam(TeamDTO teamDto) {
		Team team = modelMaper.map(teamDto, Team.class);
		
		return modelMaper.map(teamRepository.save(team), TeamDTO.class);
	}

	@Override
	public TeamDTO updateTeam(TeamDTO teamDto) {
		Team checkedTeam = teamRepository.findById(teamDto.getId())
				.orElseThrow(() -> new PersistenceException("Team not found by ID: " + teamDto.getId()));
		
		Club club;
		if (teamDto.getClubId() == null) {
			club = null;
		} else {
			club = clubRepository.findById(teamDto.getClubId())
					.orElseThrow(() -> new PersistenceException(
					"The field club in the Team class not found by ID: " + teamDto.getId()));
		}
		checkedTeam.setName(teamDto.getTeamName());
		checkedTeam.setClub(club);
		checkedTeam.setModifiedAt(LocalDateTime.now());
		
		return modelMaper.map(teamRepository.save(checkedTeam), TeamDTO.class);
	}

	@Override
	public List<TeamDTO> findTeams() {
		List<Team> teams = teamRepository.findAll();
		return teams.stream()
				.map((team) -> modelMaper.map(team, TeamDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<TeamDTO> findTeamById(Long teamId) {
		Team team = teamRepository.findById(teamId)
				.orElseThrow(() -> new PersistenceException("Team not found by ID: " + teamId));
		return Optional.of(modelMaper.map(team, TeamDTO.class));
	}

	@Override
	public boolean deleteTeam(Long teamId) {
		if(teamId != null) {
			teamRepository.deleteById(teamId);
			return true;
		} else {			
			return false;
		}
	}

}
