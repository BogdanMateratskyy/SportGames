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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kidob.sportgames.app.rest.dto.TournamentDTO;
import com.kidob.sportgames.app.service.TournamentService;

/**
 * {@link Tournament} is a REST controller that handles tournament-related
 * request
 * 
 * @author Bogdan
 *
 */
@RestController
@RequestMapping("tournament")
public class TournamentController {

	/**
	 * Underlying source of data
	 */
	@Autowired
	private TournamentService tournamentService;

	/**
	 * Saves new tournament instance
	 * 
	 * @param sportDTO
	 * @return
	 */
	@PostMapping("/save")
	public TournamentDTO saveTournament(@RequestBody TournamentDTO tournamentDto) {

		return tournamentService.saveTournament(tournamentDto);
	}

	/**
	 * Return all the existing tournaments
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public List<TournamentDTO> findAllSports() {

		return tournamentService.findTournaments();
	}

	/**
	 * Returns tournament with specified identifier
	 * 
	 * @param tournamentId
	 * @return
	 */
	@GetMapping("/by/{tournamentId}")
	public ResponseEntity<TournamentDTO> findTournamentById(@PathVariable String tournamentId) {

		if (!NumberUtils.isCreatable(tournamentId)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Optional<TournamentDTO> tournamentDTO = tournamentService.findTournamentById(NumberUtils.toLong(tournamentId));

		if (!tournamentDTO.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(tournamentDTO.get());
	}

}
