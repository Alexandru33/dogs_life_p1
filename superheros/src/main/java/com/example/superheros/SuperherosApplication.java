package com.example.superheros;

import com.example.superheros.model.Hero;
import com.example.superheros.repository.HeroRepository;
import com.example.superheros.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SuperherosApplication implements CommandLineRunner {
	@Autowired
	HeroService heroService;

	public static void main(String[] args) {
		SpringApplication.run(SuperherosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Hero> heros = heroService.getHeroesStartingWithLetter("C");
		for (Hero hero: heros) {
			System.out.println(hero);
		}
	}
}
