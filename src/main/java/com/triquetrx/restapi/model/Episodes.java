package com.triquetrx.restapi.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
public @NoArgsConstructor class Episodes {

	@Id
	private @Getter @Setter int id;
	private @Setter @Getter String episodeName;
	@ManyToMany
	@JoinTable(name = "peoples_episodes_mapping", joinColumns = @JoinColumn(name = "episode_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "people_id", referencedColumnName = "id"))
	private @Setter Set<People> peoples;

	public Episodes(int episodeNumber, String episodeName, Set<People> peoples) {
		super();
		this.id = episodeNumber;
		this.episodeName = episodeName;
		this.peoples = peoples;
	}

	@JsonManagedReference
	public Set<People> getPeoples() {
		return peoples;
	}

}
