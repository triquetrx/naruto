package com.triquetrx.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.triquetrx.restapi.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
	
}
