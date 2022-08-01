package com.triquetrx.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.triquetrx.restapi.model.Episodes;

@Repository
public interface EpisodeRepository extends JpaRepository<Episodes, Integer> {
	
}
