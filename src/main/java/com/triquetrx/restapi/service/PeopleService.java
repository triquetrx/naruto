package com.triquetrx.restapi.service;

import java.util.List;

import com.triquetrx.restapi.dto.PeopleDto;
import com.triquetrx.restapi.model.People;

public interface PeopleService {
	
	People getByName(String peopleName);
	 
	void addPeople(PeopleDto peopleDto);
	 
	List<People> getAll();

	boolean userAvailable(String peopleName);
	
	void update(PeopleDto peopleDto);

}
