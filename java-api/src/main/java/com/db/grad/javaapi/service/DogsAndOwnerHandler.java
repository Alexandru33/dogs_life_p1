package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsAndOwnerRepository;
import com.db.grad.javaapi.repository.DogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogsAndOwnerHandler {
private DogsAndOwnerRepository itsDogsRepo;

    @Autowired
    public DogsAndOwnerHandler(DogsAndOwnerRepository repo) {
        itsDogsRepo = repo;
    }


    public String getDogByName(String name) {

        List<String> dogs = itsDogsRepo.findByName(name);

        if (dogs.size() == 1)
            return dogs.get(0);
        else
            return null;
    }
}
