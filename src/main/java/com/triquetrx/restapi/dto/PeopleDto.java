package com.triquetrx.restapi.dto;

import java.util.List;

import com.triquetrx.restapi.model.Episodes;

import lombok.Data;

public @Data class PeopleDto {

	private String name;
	private String imageUrl;
	private String status;
	private String species;
	private String affiliation;
	private String rank;
	private List<Episodes> episodes;

	public PeopleDto(String name, String imageUrl, String status, String species, String affiliation, String rank) {
		super();
		this.name = name;
		this.imageUrl = imageUrl;
		this.status = status;
		this.species = species;
		this.affiliation = affiliation;
		this.rank = rank;
	}

}
