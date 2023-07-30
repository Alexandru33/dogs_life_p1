package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogHandler implements IDogsService {
    private DogsRepository itsDogsRepo;

    @Autowired
    public DogHandler(DogsRepository repo) {
        itsDogsRepo = repo;
    }

    @Override
    public Dog addDog(Dog theDog) {
        return itsDogsRepo.save(theDog);
    }

    @Override
    public long getNoOfDogs() {
        return itsDogsRepo.count();
    }

    @Override
    public List<Dog> getAllDogs() {
        return itsDogsRepo.findAll();
    }

    @Override
    public Dog getDogByName(String name) {
        Dog ourDog = new Dog();

        ourDog.setName(name);
        List<Dog> dogs = itsDogsRepo.findByName(ourDog);

        if (dogs.size() == 1)
            return dogs.get(0);
        else
            return null;
    }

    @Override
    public Dog getDogById(long id) {
        return itsDogsRepo.findById(id).get();
    }

    @Override
    public Dog updateDogDetails(Dog dogToBeUpdated) {
        // so we need to delete the dog and put it back with updated details
        return itsDogsRepo.save(dogToBeUpdated);
    }

    @Override
    public boolean removeDog(long id) {
        Optional<Dog> theDog = itsDogsRepo.findById(id);

        if(theDog.isPresent()) {
            itsDogsRepo.delete(theDog.get());
            return true;
        }
        return false;
    }
}
