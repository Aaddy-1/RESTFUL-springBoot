package com.learning.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.demo.service.PersonService;

import com.learning.demo.model.Person;

// This is a restful controller
@RestController
@RequestMapping("api/v1/user")
public class PersonController {
    private final PersonService service;

    // Spring will automatically inject the PersonService dependency using this constructor
    // (No need for making a new PersonService)
    @Autowired
    PersonController(PersonService service) {
        this.service = service;
    }
    @PostMapping
    public void addPerson(@RequestBody Person person) { // We add RequestBody annotation to take the request body and convert it into a person
        service.addPerson(person);
    }
}
