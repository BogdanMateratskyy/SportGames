package com.kidob.sportgames.app.rest.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.math.NumberUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kidob.sportgames.app.model.entity.sport.Team;
import com.kidob.sportgames.app.rest.controller.base.BaseController;
import com.kidob.sportgames.app.rest.dto.TeamDTO;
import com.kidob.sportgames.app.service.TeamService;

/**
 * {@link TeamController} is a REST controller that handles team-related request
 * 
 * @author Bogdan
 *
 */
@RestController
@RequestMapping("team")
public class TeamController {

	ModelMapper modelMapper = new ModelMapper();
	/**
	 * Underlying source of data
	 */
	@Autowired
	private TeamService teamService;

	/**
	 * Saves new team instance
	 * 
	 * @param teamDTO
	 * @return new team instance
	 */
	@PostMapping("/save")
	public Team saveTeam(@RequestBody TeamDTO teamDTO) {

		return teamService.saveTeam(modelMapper.map(teamDTO, Team.class));
	}

	/**
	 * Updates the existing teams
	 * 
	 * @param teamDTO
	 * @return
	 */
	@PutMapping("/update")
	public Team updateTeam(@RequestBody TeamDTO teamDTO) {

		Team team = modelMapper.map(teamDTO, Team.class);
		
		if (teamDTO.getId() != null) {
			team.setName(teamDTO.getTeamName());

			if (teamDTO.getClubId() != null) {
				team.getClub().setId(teamDTO.getClubId());
			}
		}
		return teamService.updateTeam(team);
	}

	/**
	 * Return all the existing teams in the form TeamDTO
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public List<TeamDTO> findAllTeams() {

		return teamService.findTeams().stream()
				.map((team) -> modelMapper.map(team, TeamDTO.class))
				.collect(Collectors.toList());
	}

	/**
	 * Returns team with specified identifier in the form TeamDTO
	 * 
	 * @param teamId
	 * @return
	 */
	@GetMapping("/by/{teamId}")
	public ResponseEntity<TeamDTO> findTeamById(@PathVariable String teamId) {

		if (!NumberUtils.isCreatable(teamId)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Optional<Team> team = teamService.findTeamById(NumberUtils.toLong(teamId));

		if (!team.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(modelMapper.map(team.get(), TeamDTO.class));
	}
}
