package com.triquetrx.restapi.service;

import java.util.List;

import com.triquetrx.restapi.model.Animal;

public interface AnimalService {

	List<Animal> getAll();
	void addNewAnimal(String name,String allies, String imageUrl, String summoner, String occupation,String species);
	
}
