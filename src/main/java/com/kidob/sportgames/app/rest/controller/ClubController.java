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

import com.kidob.sportgames.app.model.entity.sport.Club;
import com.kidob.sportgames.app.rest.dto.ClubDTO;
import com.kidob.sportgames.app.service.ClubService;

/**
 * {@link ClubController} is a REST service that handles club-related request
 * 
 * @author Bogdan
 *
 */
@RestController
@RequestMapping("club")
public class ClubController {

	ModelMapper modelMapper = new ModelMapper();
	/**
	 * Underlying source of data
	 */
	@Autowired
	private ClubService clubService;

	/**
	 * Saves new club instance
	 * 
	 * @param clubDto
	 * @return
	 */
	@PostMapping ("/save")
	public Club saveClub(@RequestBody ClubDTO clubDto) {
		return clubService.saveClub(modelMapper.map(clubDto, Club.class));
	}

	/**
	 * Updates the existing club
	 * 
	 * @param clubDTO
	 * @return
	 */
	@PutMapping ("/update")
	public Club updateClub(@RequestBody ClubDTO clubDTO) {
		return clubService.updateClub(modelMapper.map(clubDTO, Club.class));
	}

	/**
	 * Return list of existing clubs in the form ClubDTO
	 * 
	 * @return
	 */
	@GetMapping ("/all")
	public List<ClubDTO> findAllClubs() {
		return clubService.findClubs().stream()
				.map((club) -> modelMapper.map(club, ClubDTO.class))
				.collect(Collectors.toList());

	}

	/**
	 * Returns club with specified identifier in the form ClubDTO
	 * 
	 * @param clubId
	 * @return
	 */
	@GetMapping ("/by/{clubId}")
	public ResponseEntity<ClubDTO> findClubById(@PathVariable String clubId) {
		
		if(!NumberUtils.isCreatable(clubId)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Optional<Club> club = clubService.findClubById(NumberUtils.toLong(clubId));
		
		if(!club.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(modelMapper.map(club.get(), ClubDTO.class));
	}
}
