package com.kidob.sportgames.app.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kidob.sportgames.app.model.entity.sport.Sport;

/**
 * Describes CRUD methods to access Sport object in the persistence storage
 * 
 * @author Bogdan
 *
 */
public interface SportRepository extends JpaRepository<Sport, Long>{

}
