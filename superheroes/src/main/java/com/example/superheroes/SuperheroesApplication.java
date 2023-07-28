package com.example.superheroes;

import com.example.superheroes.practice.Calculator;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuperheroesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SuperheroesApplication.class, args);
	}

	@Autowired
	Calculator calc;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Bonjour, world!");

		int result = calc.addition(3,4);
		System.out.println(result);


	}

	@PostConstruct
	public void init() {
		System.out.println("Started Bean");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Calcuator will be destroyed");
	}

}
