package com.triquetrx.restapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
public @Data @NoArgsConstructor class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "Name can not be empty")
	private String name;
	@NotNull(message = "Image Url can not be empty")
	private String imageUrl;
	@NotNull(message = "Summoner can not be empty")
	private String summoner;
	@NotNull(message = "Species can not be empty")
	private String species;
	@NotNull(message = "Allies can not be empty")
	private String allies;
	private String occupation;

	public Animal(String name, String allies,String imageUrl, String summoner, String occupation, String species) {
		super();
		this.name = name;
		this.allies=allies;
		this.imageUrl = imageUrl;
		this.summoner = summoner;
		this.occupation = occupation;
		this.species = species;
	}

}
