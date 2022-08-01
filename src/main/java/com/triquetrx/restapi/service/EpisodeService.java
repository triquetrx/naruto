package com.triquetrx.restapi.service;

import java.util.List;

import com.triquetrx.restapi.dto.EpisodeDto;
import com.triquetrx.restapi.model.Episodes;

public interface EpisodeService {
	
	void save(EpisodeDto episodeDto);
	  
	Episodes getByEpisodeNumber(int episodeNumber);
	
	List<Episodes> getAll();

}
