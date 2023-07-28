package com.example.superheroes;

import com.example.superheroes.model.Hero;
import com.example.superheroes.practice.Calculator;
import com.example.superheroes.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SuperheroesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SuperheroesApplication.class, args);
	}

	@Autowired
	HeroService heroService;


	@Autowired
	Calculator calc;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Bonjour, world!");


		List<Hero> heroes = heroService.getLastThreeHeroesByName();
		for (Hero hero : heroes )
		{
			System.out.println(hero);
		}

	}



}
