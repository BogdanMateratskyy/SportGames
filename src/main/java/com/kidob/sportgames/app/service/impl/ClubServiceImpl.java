package com.kidob.sportgames.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidob.sportgames.app.infra.exception.PersistenceException;
import com.kidob.sportgames.app.model.entity.sport.Club;
import com.kidob.sportgames.app.persistence.repository.ClubRepository;
import com.kidob.sportgames.app.service.ClubService;

/**
 * Default implementation of the {@link ClubService}
 * 
 * @author Bogdan
 *
 */
@Service
public class ClubServiceImpl implements ClubService {

	@Autowired
	private ClubRepository clubRepository;

	@Override
	public Club saveClub(Club club) {
		return clubRepository.save(club);
	}

	@Override
	public Club updateClub(Club club) {
		Club checkedClub = clubRepository.findById(club.getId())
				.orElseThrow(() -> new PersistenceException("Club not found!"));
				
		return clubRepository.saveAndFlush(checkedClub);
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
