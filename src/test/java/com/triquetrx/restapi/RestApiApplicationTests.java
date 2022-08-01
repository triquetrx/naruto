package com.triquetrx.restapi;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.triquetrx.restapi.dto.PeopleDto;
import com.triquetrx.restapi.repository.PeopleRepository;
import com.triquetrx.restapi.service.EpisodeService;
import com.triquetrx.restapi.service.PeopleService;

@SpringBootTest
class RestApiApplicationTests {

	@Autowired
	EpisodeService episodeService;

	@Autowired
	PeopleService peopleService;

	@Autowired
	PeopleRepository repos;

	@Test
	void contextLoads() {
	}

	@Test
	void updateCharacterData() {

		List<PeopleDto> characters = new ArrayList<>();

		characters.add(new PeopleDto("Hinata Uzumaki",
				"https://static.wikia.nocookie.net/boruto/images/9/96/Hinata_Boruto_series.jpg", "Alive", "Human",
				"Konohagakure, Allied Shinobi Forces, Hyuga Clan, Uzumaki Clan", "Chunin"));
		characters.add(
				new PeopleDto("Sasuke Uchiha", "https://static.wikia.nocookie.net/boruto/images/b/b7/Sasuke_Epilogue.png",
						"Alive", "Human", "Uchiha Clan, Konohagakure", "Jonin"));
		characters.add(new PeopleDto("Iruka Umino", "https://static.wikia.nocookie.net/boruto/images/4/4a/Iruka_umino.png",
				"Alive", "Human", "Konohagakure", "Chunin"));
		characters.add(new PeopleDto("Mizuki", "https://static.wikia.nocookie.net/villains/images/0/07/Mizuki_FIller.png",
				"Deceased", "Human", "Konohagakure, Orichimaru", "Chunin"));
		characters.add(new PeopleDto("Sakura Uchiha",
				"https://static.wikia.nocookie.net/boruto/images/1/16/Sakura_Uchiha_Anime_Boruto.png", "Alive", "Human",
				"Konohagakure, Shikkotsu Forest, Allied Shinobi Forces", "Jonin"));
		characters.add(
				new PeopleDto("Ino Yamanaka", "https://static.wikia.nocookie.net/boruto/images/8/8c/Ino_Boruto_Series.jpg",
						"Alive", "Human", "Konohagakure,Allied Shinobi Forces,Yamanaka Clan", "Jonin"));
		characters.add(new PeopleDto("Hiruzen Sarutobi",
				"https://static.wikia.nocookie.net/naruto/images/e/e4/Hiruzen_Sarutobi.png/", "Deceased", "Human",
				"Konohagakure, Sarutobi Clan", "Kage (Former)"));
		characters.add(new PeopleDto("Shikamaru Nara",
				"https://static.wikia.nocookie.net/naruto/images/5/55/Shikamaru_Part_III.png/", "Alive", "Human",
				"Konohagakure, Allied Shinobi Forces, Nara Clan", "Jonin"));
		characters.add(new PeopleDto("Naruto Uzumaki",
				"https://static.wikia.nocookie.net/boruto/images/9/9d/375px-NarutoBorutoMovie.jpg", "Alive", "Human",
				"Uzumaki Clan, Konohagakure, Mount Myoboku, Allied Shinobi Forces", "Kage"));
		characters.add(new PeopleDto("Ebisu",
				"https://static.wikia.nocookie.net/naruto/images/7/77/Ebisu.png", "Alive", "Human",
				"Konohagakure,Allied Shinobi Forces", "Jonin"));
		characters.add(new PeopleDto("Konohamaru sarutobi",
				"https://static.wikia.nocookie.net/naruto/images/b/b1/Konohamaru_Part_3.png", "Alive", "Human",
				"Saratobi Clan, Konohagakure, Mount Myoboku", "Jonin"));
		
		for(PeopleDto character:characters) {
			peopleService.update(character);
		}
		
	}
	
//	@Test
//	void addEpisodes() {
//		
//		List<String> names = new ArrayList<>();
//		
//		names.add("Ebisu");
//		names.add("Konohamaru sarutobi");
//		names.add("Naruto Uzumaki");
//		names.add("Hiruzen Sarutobi");
//		names.add("Iruka Umino");
//		names.add("Sasuke Uchiha");
//		names.add("Hinata Uzumaki");
//		names.add("Mizuki");
//		names.add("Ino Yamanaka");
//		names.add("Shikamaru Nara");
//		names.add("Sakura Uchiha");
//		
//		EpisodeDto dto = new EpisodeDto(1, "Enters Naruto Uzumaki", names);
//		EpisodeDto dto = new EpisodeDto(2, "My Name is Konohamaru", names);
//		episodeService.save(dto);
//	}

}
