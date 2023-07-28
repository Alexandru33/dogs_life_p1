package com.example.superheros;

import com.example.superheros.practice.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuperherosApplication implements CommandLineRunner {

	@Autowired
	Calculator cal;
	public static void main(String[] args) {
		SpringApplication.run(SuperherosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World!");
		int result = cal.addition(3, 4);
		System.out.println(result);
	}
}
