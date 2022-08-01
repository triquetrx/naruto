package com.triquetrx.restapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.triquetrx.restapi.model.People;

public interface PeopleRepository extends JpaRepository<People, Integer>{
	
	Optional<People> findByName(String name);
	boolean existsByName(String name);
	void deleteByName(String name);
	
}
