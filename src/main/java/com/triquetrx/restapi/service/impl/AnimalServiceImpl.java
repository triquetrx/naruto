package com.triquetrx.restapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triquetrx.restapi.model.Animal;
import com.triquetrx.restapi.repository.AnimalRepository;
import com.triquetrx.restapi.service.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService {
	
	@Autowired
	AnimalRepository repos;
	
	public List<Animal> getAll() {
		return repos.findAll();
	}
	
	public void addNewAnimal(String name,String allies, String imageUrl, String summoner, String occupation,String species) {
		repos.save(new Animal(name,allies,imageUrl,summoner,occupation,species));
	}
	
}
