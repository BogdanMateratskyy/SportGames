package com.kidob.sportgames.app.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidob.sportgames.app.infra.exception.PersistenceException;
import com.kidob.sportgames.app.model.entity.sport.Tournament;
import com.kidob.sportgames.app.persistence.repository.TournamentRepository;
import com.kidob.sportgames.app.rest.dto.TournamentDTO;
import com.kidob.sportgames.app.service.TournamentService;

/**
 * Default implementation of the {@link
 * 
 * @author Bogdan
 *
 */
@Service
public class TournamentServiceImlp implements TournamentService {

	ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private TournamentRepository tournamentRepository;

	@Override
	public TournamentDTO saveTournament(TournamentDTO tournamentDto) {
		Tournament tournament = tournamentRepository.save(modelMapper.map(tournamentDto, Tournament.class));

		return modelMapper.map(tournament, TournamentDTO.class);
	}

	@Override
	public List<TournamentDTO> findTournaments() {
		List<Tournament> tournaments = tournamentRepository.findAll();

		return tournaments.stream()
				.map((tournament) -> modelMapper.map(tournament, TournamentDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<TournamentDTO> findTournamentById(Long tournamentId) {
		Tournament tournament = tournamentRepository.findById(tournamentId)
				.orElseThrow(() -> new PersistenceException("Tournament not found by ID: " + tournamentId));
		
		return Optional.of(modelMapper.map(tournament, TournamentDTO.class));
	}

}
