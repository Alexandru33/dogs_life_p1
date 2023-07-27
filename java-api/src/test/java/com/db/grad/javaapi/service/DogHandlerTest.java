package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DogHandlerTest {

    private DogsRepository itsDogsRepo = new DogsRepositoryStub();
    private DogHandler handler = null;

    @BeforeEach
    public void makeSureRepoIsEmpty(){

        itsDogsRepo.deleteAll();
        handler = new DogHandler(itsDogsRepo);
    }

    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one() {
        // arrange


        Dog theDog = new Dog();
        theDog.setName("Bruno");
        handler.addDog(theDog);

        int expectedResult = 1;

        // act
        long actualResult = handler.getNoOfDogs();

        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void find_dog_by_name() {

        Dog theFirstDog = new Dog();
        theFirstDog.setName("Alpha");
        handler.addDog(theFirstDog);

        Dog theSecondDog = new Dog();
        theSecondDog.setName("Bruno");
        handler.addDog(theSecondDog);

        Dog theThirdDog = new Dog();
        theThirdDog.setName("Charlie");
        handler.addDog(theThirdDog);

        Dog theFourthDog = new Dog();
        theFourthDog.setName("Bruno");
        handler.addDog(theFourthDog);

        // assert: no another dog has this name, return this dog

        assertEquals(handler.getDogByName("Alpha"), theFirstDog);


    }


    @Test
    public void find_dog_by_name_multiple_dogs() {

        Dog theFirstDog = new Dog();
        theFirstDog.setName("Alpha");
        handler.addDog(theFirstDog);

        Dog theSecondDog = new Dog();
        theSecondDog.setName("Bruno");
        handler.addDog(theSecondDog);

        Dog theThirdDog = new Dog();
        theThirdDog.setName("Charlie");
        handler.addDog(theThirdDog);

        Dog theFourthDog = new Dog();
        theFourthDog.setName("Bruno");
        handler.addDog(theFourthDog);
        // assert: two dogs have the same name, return null
        Dog dogToFind2 = handler.getDogByName("Bruno");
        assertNull(dogToFind2);
    }


    @Test
    public void find_dog_by_name_no_dog() {

        Dog theFirstDog = new Dog();
        theFirstDog.setName("Alpha");
        handler.addDog(theFirstDog);

        Dog theSecondDog = new Dog();
        theSecondDog.setName("Bruno");
        handler.addDog(theSecondDog);

        Dog theThirdDog = new Dog();
        theThirdDog.setName("Charlie");
        handler.addDog(theThirdDog);

        Dog theFourthDog = new Dog();
        theFourthDog.setName("Bruno");
        handler.addDog(theFourthDog);
        // assert: no dog has this name, return null
        Dog dogToFind3 = handler.getDogByName("Luna");
        assertNull(dogToFind3);
    }

    @Test
    public void find_dog_by_id_valid() {


        Dog theFirstDog = new Dog();
        theFirstDog.setName("Alpha");
        handler.addDog(theFirstDog);

        Dog theSecondDog = new Dog();
        theSecondDog.setName("Bruno");
        handler.addDog(theSecondDog);

        Dog theThirdDog = new Dog();
        theThirdDog.setName("Charlie");
        handler.addDog(theThirdDog);

        Dog theFourthDog = new Dog();
        theFourthDog.setName("Luna");
        handler.addDog(theFourthDog);

        // assert: valid id

        assertEquals(handler.getDogById(1), theFirstDog);

    }

    @Test
    public void find_dog_by_id_invalid() {


        Dog theFirstDog = new Dog();
        theFirstDog.setName("Alpha");
        handler.addDog(theFirstDog);

        Dog theSecondDog = new Dog();
        theSecondDog.setName("Bruno");
        handler.addDog(theSecondDog);

        Dog theThirdDog = new Dog();
        theThirdDog.setName("Charlie");
        handler.addDog(theThirdDog);

        Dog theFourthDog = new Dog();
        theFourthDog.setName("Luna");
        handler.addDog(theFourthDog);


        // assert: invalid id
        Dog dogToFind2 = handler.getDogById(11);
        assertNull(dogToFind2);
    }

    @Test
    public void update_a_dog() {

        Dog theFirstDog = new Dog();
        theFirstDog.setName("Alpha");
        handler.addDog(theFirstDog);

        Dog theSecondDog = new Dog();
        theSecondDog.setName("Bruno");
        handler.addDog(theSecondDog);

        Dog theThirdDog = new Dog();
        theThirdDog.setName("Charlie");
        handler.addDog(theThirdDog);

        Dog theFourthDog = new Dog();
        theFourthDog.setName("Luna");
        handler.addDog(theFourthDog);

        // act: update the first dog's name
        Dog dogToBeUpdated = theFirstDog;
        dogToBeUpdated.setName("Mike");
        long actualId = handler.updateDogDetails(dogToBeUpdated);

        // assert: id should be 1 here
        assertEquals(1, actualId);
    }

    @Test
    public void remove_a_dog_return_true() {


        Dog theFirstDog = new Dog();
        theFirstDog.setName("Alpha");
        handler.addDog(theFirstDog);

        Dog theSecondDog = new Dog();
        theSecondDog.setName("Bruno");
        handler.addDog(theSecondDog);

        Dog theThirdDog = new Dog();
        theThirdDog.setName("Charlie");
        handler.addDog(theThirdDog);

        Dog theFourthDog = new Dog();
        theFourthDog.setName("Luna");
        handler.addDog(theFourthDog);

        // act: remove Charlie from the dog repo
        Dog dogToBeRemoved = theThirdDog;
        boolean actualStatus = handler.removeDog(dogToBeRemoved.getId());

        // assert: should return true and cannot get this dog anymore
        assertTrue(actualStatus);


    }



    @Test
    public void remove_a_dog_return_false() {
        Dog theFirstDog = new Dog();
        theFirstDog.setName("Alpha");
        handler.addDog(theFirstDog);

        Dog theSecondDog = new Dog();
        theSecondDog.setName("Bruno");
        handler.addDog(theSecondDog);

        Dog theThirdDog = new Dog();
        theThirdDog.setName("Charlie");
        handler.addDog(theThirdDog);

        Dog theFourthDog = new Dog();
        theFourthDog.setName("Luna");
        handler.addDog(theFourthDog);


        // act: remove a non-exist dog
        boolean actualStatus1 = handler.removeDog(20);


        // assert: should return false and cannot get this dog
        assertFalse(actualStatus1);

    }

    @Test
    public void count_dogs() {

        Dog theFirstDog = new Dog();
        theFirstDog.setName("Alpha");
        handler.addDog(theFirstDog);

        Dog theSecondDog = new Dog();
        theSecondDog.setName("Bruno");
        handler.addDog(theSecondDog);

        Dog theThirdDog = new Dog();
        theThirdDog.setName("Charlie");
        handler.addDog(theThirdDog);

        assertEquals(3, handler.getNoOfDogs());


    }
}
