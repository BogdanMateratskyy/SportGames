package com.kidob.sportgames.app.service.impl;

import java.util.List;
import java.util.Optional;

import com.kidob.sportgames.app.infra.exception.PersistenceException;
import com.kidob.sportgames.app.model.entity.sport.Club;
import com.kidob.sportgames.app.persistence.repository.ClubRepository;
import com.kidob.sportgames.app.rest.dto.ClubDTO;
import com.kidob.sportgames.app.service.ClubService;

/**
 * Default implementation of the {@link ClubService}
 * 
 * @author Bogdan
 *
 */
public class ClubServiceImpl implements ClubService {

	private ClubRepository clubRepository;

	@Override
	public Club saveClub(Club club) {
		return clubRepository.save(club);
	}

	@Override
	public Club updateClub(ClubDTO clubDTO) {
		Club club = clubRepository.findById(clubDTO.getId())
				.orElseThrow(() -> new PersistenceException("Club not found!"));
		
		club.setClubName(clubDTO.getName());
		
		return clubRepository.saveAndFlush(club);
	}

	@Override
	public List<Club> findClubs() {
		return clubRepository.findAll();
	}

	@Override
	public Optional<Club> findClubById(Long clubId) {
		return clubRepository.findById(clubId);
	}

}
