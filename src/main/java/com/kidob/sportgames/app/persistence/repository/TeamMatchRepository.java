package com.kidob.sportgames.app.persistence.repository;

import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kidob.sportgames.app.model.entity.location.Place;
import com.kidob.sportgames.app.model.entity.sport.Matches;
import com.kidob.sportgames.app.model.entity.sport.TeamMatch;

/**
 * Describes CRUD methods to access TeamMatch object in the persistence storage
 * 
 * @author Bogdan
 *
 */
public interface TeamMatchRepository extends JpaRepository<TeamMatch, Long> {

	/**
	 * Method allows finding TeamMatch object in the persistence storage by the
	 * match and the place where the team plays
	 * 
	 * @param match
	 * @param place
	 * @return
	 */
	default TeamMatch findTeamMatchByMatch(Matches match, Place place) {
		return findAll().stream()
				.filter(teamMatch -> match.getId() == teamMatch.getMatch().getId())
				.filter(teamMatch -> place.equals(teamMatch.getPlace()))
				.collect(Collectors.toList()).get(0);
	}
}
