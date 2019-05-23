package com.kidob.sportgames.app.rest.controller;

import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.math.NumberUtils;
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
	public TeamDTO saveTeam(@RequestBody TeamDTO teamDTO) {

		return teamService.saveTeam(teamDTO);
	}

	/**
	 * Updates the existing teams
	 * 
	 * @param teamDTO
	 * @return
	 */
	@PutMapping("/update")
	public TeamDTO updateTeam(@RequestBody TeamDTO teamDto) {
		
		return teamService.updateTeam(teamDto);
	}

	/**
	 * Return all the existing teams
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public List<TeamDTO> findAllTeams() {

		return teamService.findTeams();
	}

	/**
	 * Returns team with specified identifier
	 * 
	 * @param teamId
	 * @return
	 */
	@GetMapping("/by/{teamId}")
	public ResponseEntity<TeamDTO> findTeamById(@PathVariable String teamId) {

		if (!NumberUtils.isCreatable(teamId)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Optional<TeamDTO> teamDto = teamService.findTeamById(NumberUtils.toLong(teamId));

		if (!teamDto.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(teamDto.get());
	}
}
