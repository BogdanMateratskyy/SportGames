package com.kidob.sportgames.app.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kidob.sportgames.app.model.entity.sport.Tournament;

/**
 * Describes CRUD methods to access Tournament object in the persistence storage
 * 
 * @author Bogdan
 *
 */
public interface TournamentRepository extends JpaRepository<Tournament, Long>{

}
