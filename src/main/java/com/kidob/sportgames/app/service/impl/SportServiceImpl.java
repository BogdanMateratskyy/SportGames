package com.kidob.sportgames.app.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.kidob.sportgames.app.infra.exception.PersistenceException;
import com.kidob.sportgames.app.model.entity.sport.Sport;
import com.kidob.sportgames.app.persistence.repository.SportRepository;
import com.kidob.sportgames.app.rest.dto.SportDTO;
import com.kidob.sportgames.app.service.SportService;

/**
 * Default implementation of the {@link SportService}
 * 
 * @author Bogdan
 *
 */
public class SportServiceImpl implements SportService{

	@Autowired
	ModelMapper modelMaper = new ModelMapper();
	
	@Autowired
	private SportRepository sportRepository;
	
	@Override
	public SportDTO saveSport(SportDTO sportDto) {

		Sport sport = sportRepository.save(modelMaper.map(sportDto, Sport.class));
		
		return modelMaper.map(sport, SportDTO.class);
	}

	@Override
	public List<SportDTO> findSports() {
		List<Sport> sportList = sportRepository.findAll();
		
		return sportList.stream()
				.map((sport) -> modelMaper.map(sport, SportDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<SportDTO> findSportById(Long sportId) {
		Sport sport = sportRepository.findById(sportId)
				.orElseThrow(() -> new PersistenceException("Sport not found with ID: " + sportId));
		return Optional.of(modelMaper.map(sport, SportDTO.class));
	}

}
