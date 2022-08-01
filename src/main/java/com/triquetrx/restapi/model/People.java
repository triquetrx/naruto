package com.triquetrx.restapi.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
public @Data @NoArgsConstructor class People {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String imageUrl;
	private String status;
	private String species;
	private String affiliation;
	private String rank;
	@ManyToMany(mappedBy = "peoples")
	@JsonBackReference
	private Set<Episodes> episodes;

	public People(String name, String imageUrl, String status, String species, String affiliation, String rank) {
		super();
		this.name = name;
		this.imageUrl = imageUrl;
		this.status = status;
		this.species = species;
		this.affiliation = affiliation;
		this.rank = rank;
	}

}
