package com.kidob.sportgames.app.rest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kidob.sportgames.app.model.entity.sport.Team;
import com.kidob.sportgames.app.rest.dto.TeamDTO;
import com.kidob.sportgames.app.service.TeamService;

@RestController
@RequestMapping("team")
public class TeamController {

	ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private TeamService teamService;

	/**
	 * Saves new team instance
	 * 
	 * @param teamDTO
	 * @return new team instance
	 */
	public Team saveTeam(@RequestBody TeamDTO teamDTO) {
		return teamService.saveTeam(modelMapper.map(teamDTO, Team.class));
	}

	public Team updateTeam(@RequestBody TeamDTO teamDTO) {
		return teamService.updateTeam(modelMapper.map(teamDTO, Team.class));
	}

	public List<TeamDTO> findAllTeams() {
		return teamService.findTeams().stream()
				.map((team) -> modelMapper.map(team, TeamDTO.class))
				.collect(Collectors.toList());
	}

	public Team findTeamById(Long teamId) {
		return teamService.findTeamById(teamId);
	}
}
