package com.kidob.sportgames.app.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kidob.sportgames.app.model.entity.sport.Team;

/**
 * Defines CRUD methods to access Team object in the persistence storage
 * 
 * @author Bogdan
 *
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{

}
