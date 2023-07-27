package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

import java.util.List;

public class DogHandler {
    private DogsRepository itsDogsRepo;
    public DogHandler(DogsRepository repo) {
        itsDogsRepo = repo;
    }

    public long addDog(Dog theDog) {
        return itsDogsRepo.save(theDog);
    }

    public long getNoOfDogs() {
        return itsDogsRepo.count();
    }

    public Dog getDogByName(String name) {
        Dog ourDog = new Dog();

        ourDog.setName(name);
        List<Dog> dogs = itsDogsRepo.findByName(ourDog);

        if( dogs.size() == 1)
            return dogs.get(0);
        else
            return null;
    }

    public Dog getDogById(long id) {
        return itsDogsRepo.findById(id);
    }

    public long updateDogDetails(Dog dogToBeUpdated) {
        return itsDogsRepo.save(dogToBeUpdated);
    }

    public Boolean removeDog(long id) {
        Dog theDog = itsDogsRepo.findById(id);

        if(theDog != null) {
            itsDogsRepo.delete(theDog);
            return true;
        } else
            return false;
    }
}
