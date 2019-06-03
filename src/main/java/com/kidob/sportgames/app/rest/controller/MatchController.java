package com.kidob.sportgames.app.rest.controller;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kidob.sportgames.app.rest.dto.MatchDTO;
import com.kidob.sportgames.app.service.MatchService;

/**
 * {@link TeamController} is a REST controller that handles team-related request
 * 
 * @author Bogdan
 *
 */
@RestController
@RequestMapping("match")
public class MatchController {

	/**
	 * Underlying source of data
	 */
	@Autowired
	private MatchService matchService;

	/**
	 * Saves new match instance
	 * 
	 * @param matchDTO
	 * @return
	 */
	@PostMapping("/save")
	public MatchDTO saveMatch(@RequestBody MatchDTO matchDto) {

		return matchService.saveMatch(matchDto);
	}

	/**
	 * Updates the existing matches
	 * 
	 * @param matchDto
	 * @return
	 */
	@PutMapping("/update")
	public MatchDTO updateMatch(@RequestBody MatchDTO matchDto) {
		
		return matchService.updateMatch(matchDto);
	}

	/**
	 * Return all the existing matches
	 * 
	 * @return
	 */
	@GetMapping(path = "/all", 
			produces = {MediaType.APPLICATION_JSON_VALUE,
						MediaType.APPLICATION_XML_VALUE})
	public List<MatchDTO> findAllMatches() {

		return matchService.findMatches();
	}

	/**
	 * Returns match with specified identifier
	 * 
	 * @param matchId
	 * @return
	 */
	@GetMapping("/by/{matchId}")
	public ResponseEntity<MatchDTO> findMatchById(@PathVariable String matchId) {

		if (!NumberUtils.isCreatable(matchId)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Optional<MatchDTO> matchDto = matchService.findMatchById(NumberUtils.toLong(matchId));

		if (!matchDto.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(matchDto.get());
	}
}
