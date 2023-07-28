package com.example.superheroes;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.superheroes.practice.Calculator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuperheroesApplication implements CommandLineRunner {

	@Autowired
	Calculator calc;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World");
		System.out.println(calc.addition(1,2));
	}

	public static void main(String[] args) {
		SpringApplication.run(SuperheroesApplication.class, args);
	}

}
