package com.triquetrx.restapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triquetrx.restapi.dto.EpisodeDto;
import com.triquetrx.restapi.dto.PeopleDto;
import com.triquetrx.restapi.model.Animal;
import com.triquetrx.restapi.service.AnimalService;
import com.triquetrx.restapi.service.EpisodeService;
import com.triquetrx.restapi.service.PeopleService;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	PeopleService peopleService;

	@Autowired
	AnimalService animalService;

	@Autowired
	EpisodeService episodeService;

	@GetMapping("/hello")
	public String helloWorld() {
		return "hello";
	}

	@GetMapping("/characters")
	public List<?> characters() {
		return peopleService.getAll();
	}

	@GetMapping("/animals")
	public List<?> animals() {
		return animalService.getAll();
	}

	@GetMapping("/episodes")
	public List<?> episodes() {
		return episodeService.getAll();
	}

	@PutMapping("/addNew")
	public ResponseEntity<?> addNewCharacter(@RequestBody PeopleDto people) {
		peopleService.addPeople(people);
		return ResponseEntity.ok("Added New");
	}

	@PutMapping("/addNewAnimal")
	public ResponseEntity<?> addNewAnimal(@RequestBody @Valid Animal animal) {
		animalService.addNewAnimal(animal.getName(), animal.getAllies(), animal.getImageUrl(), animal.getSummoner(),
				animal.getOccupation(), animal.getSpecies());
		return ResponseEntity.ok("Added new animal");
	}

	@PutMapping("/addNewEpisodes")
	public ResponseEntity<?> addNewEpisodes(@RequestBody EpisodeDto episodes) {

		episodeService.save(episodes);

		return ResponseEntity.ok("Added new Episode");
	}

}
