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

import com.kidob.sportgames.app.rest.dto.SportDTO;
import com.kidob.sportgames.app.service.SportService;

/**
* {@link SportController} is a REST controller that handles sport-related request
* 
* @author Bogdan
*
*/
@RestController
@RequestMapping ("sport")
public class SportController {

	/**
	 * Underlying source of data
	 */
	@Autowired
	private SportService sportService;

	/**
	 * Saves new sport instance
	 * 
	 * @param sportDTO
	 * @return
	 */
	@PostMapping("/save")
	public SportDTO saveSport(@RequestBody SportDTO sportDto) {

		return sportService.saveSport(sportDto);
	}

	/**
	 * Return all the existing sports
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public List<SportDTO> findAllSports() {

		return sportService.findSports();
	}

	/**
	 * Returns sport with specified identifier
	 * 
	 * @param sportId
	 * @return
	 */
	@GetMapping("/by/{sportId}")
	public ResponseEntity<SportDTO> findSportById(@PathVariable String sportId) {

		if (!NumberUtils.isCreatable(sportId)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Optional<SportDTO> sportDto = sportService.findSportById(NumberUtils.toLong(sportId));

		if (!sportDto.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(sportDto.get());
	}
}
