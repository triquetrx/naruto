package com.triquetrx.restapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triquetrx.restapi.dto.PeopleDto;
import com.triquetrx.restapi.model.People;
import com.triquetrx.restapi.repository.PeopleRepository;
import com.triquetrx.restapi.service.PeopleService;

@Service
public class PeopleServiceImpl implements PeopleService {

	@Autowired
	PeopleRepository peopleRepository;

	@Override
	public People getByName(String peopleName) {
		return peopleRepository.findByName(peopleName).get();
	}

	@Override
	public void addPeople(PeopleDto peopleDto) {

		People people = new People(peopleDto.getName(), peopleDto.getImageUrl(), peopleDto.getStatus(),
				peopleDto.getSpecies(), peopleDto.getAffiliation(), peopleDto.getRank());

		peopleRepository.save(people);

	}

	@Override
	public List<People> getAll() {
		return peopleRepository.findAll();
	}

	@Override
	public boolean userAvailable(String peopleName) {
		return peopleRepository.existsByName(peopleName);
	}

	@Override
	public void update(PeopleDto peopleDto) {
		if(userAvailable(peopleDto.getName())) {
			People people = getByName(peopleDto.getName());
			people.setImageUrl(peopleDto.getImageUrl());
			people.setRank(peopleDto.getRank());
			people.setSpecies(peopleDto.getSpecies());
			people.setStatus(peopleDto.getStatus());
			people.setAffiliation(peopleDto.getAffiliation());
			peopleRepository.save(people);
			return;
		}
		addPeople(peopleDto);
	}
	
	

}
