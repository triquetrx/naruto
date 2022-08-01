package com.triquetrx.restapi.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triquetrx.restapi.dto.EpisodeDto;
import com.triquetrx.restapi.dto.PeopleDto;
import com.triquetrx.restapi.model.Episodes;
import com.triquetrx.restapi.model.People;
import com.triquetrx.restapi.repository.EpisodeRepository;
import com.triquetrx.restapi.service.EpisodeService;
import com.triquetrx.restapi.service.PeopleService;

@Service
public class EpisodeServiceImpl implements EpisodeService{
	
	@Autowired
	private EpisodeRepository episodeRepository;
	
	@Autowired
	private PeopleService peopleService;
	private int episodeNumber;
	Logger log = LoggerFactory.getLogger(getClass());

	@Override
	@Transactional
	public void save(EpisodeDto episodeDto) {
		episodeNumber = (int)episodeRepository.count();
		episodeDto.setEpisodeNumber(episodeNumber+1);
		Episodes episodes = new Episodes();
		episodes.setEpisodeName(episodeDto.getEpisodeName());
		episodes.setId(episodeDto.getEpisodeNumber());
		
		List<People> peoples = new ArrayList<>();
		for(String peopleName:episodeDto.getPeopleNames()) {
			if(peopleService.userAvailable(peopleName)) {
				peoples.add(peopleService.getByName(peopleName));
			} else {
				PeopleDto peopleDto = new PeopleDto(peopleName, null, null, null, null, null);
				peopleService.addPeople(peopleDto);
				peoples.add(peopleService.getByName(peopleName));
			}
		}
		
		episodes.setPeoples(new HashSet<>(peoples));
		log.info(episodes.toString());
		episodeRepository.save(episodes);
	}

	@Override
	public Episodes getByEpisodeNumber(int episodeNumber) {
		return episodeRepository.findById(episodeNumber).get();
	}

	@Override
	public List<Episodes> getAll() {
		return episodeRepository.findAll();
	}

}
