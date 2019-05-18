package com.kidob.sportgames.app.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kidob.sportgames.app.model.entity.sport.Club;

/**
 * Describes CRUD methods to access Club object in the persistence storage
 * 
 * @author Bogdan
 *
 */
public interface ClubRepository extends JpaRepository<Club, Long>{

}