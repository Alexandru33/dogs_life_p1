package com.example.superheroes.practice;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Calculator {
    public int addition ( int num1, int num2)
    {
        return num1+num2;

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
