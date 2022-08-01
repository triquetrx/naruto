package com.triquetrx.restapi.dto;

import java.util.List;

import lombok.Data;

public @Data class EpisodeDto {
	
	private int episodeNumber;
	private String episodeName;
	private List<String> peopleNames;
	
	public EpisodeDto(int episodeNumber, String episodeName, List<String> peopleNames) {
		super();
		this.episodeNumber = episodeNumber;
		this.episodeName = episodeName;
		this.peopleNames = peopleNames;
	}
	
	
}
