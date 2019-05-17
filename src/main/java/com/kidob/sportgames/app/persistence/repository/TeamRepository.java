package com.kidob.sportgames.app.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kidob.sportgames.app.model.entity.sport.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{

}
