package com.db.grad.javaapi.controller;


import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.service.DogHandler;
import com.db.grad.javaapi.service.DogsAndOwnerHandler;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class DogsAndOwnersController {
    private DogsAndOwnerHandler dogsService;

    @Autowired    public DogsAndOwnersController(DogsAndOwnerHandler ds) {
        dogsService = ds;
    }

    @GetMapping("/owners/{id}")
    public ResponseEntity < String > getEmployeeById(@PathVariable(value = "id") String id)
            throws ResourceNotFoundException {
        String dogs = dogsService.getDogByName(id);
        return ResponseEntity.ok().body(dogs);
    }


}


