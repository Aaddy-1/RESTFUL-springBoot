package com.learning.demo.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.demo.service.PersonService;

import com.learning.demo.model.Person;

// This is a restful controller
@RestController
@RequestMapping("api/v1/user")
public class PersonController {
    // Our person service that we are going to use
    private final PersonService service;

    // Spring will automatically inject the PersonService dependency using this constructor
    // (No need for making a new PersonService)
    @Autowired
    PersonController(PersonService service) {
        this.service = service;
    }
    
    // This will handle post requests
    @PostMapping
    public void addPerson(@RequestBody Person person) { // We add RequestBody annotation to take the request body and convert it into a person
        service.addPerson(person);
    }

    // This will handle get requests
    @GetMapping
    public List<Person> getAllPeople() {
        return service.returnAllPeople();
    }

    // When we want to add url params to the get request
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return service.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public int deletePersonById(@PathVariable("id") UUID id) {
        return service.deletePersonById(id);
    }

    @PutMapping(path = "{id}")
    public int updatePersonById(@PathVariable UUID id, @RequestBody Person newPerson) {
        return service.updatePersonById(id, newPerson);
    }


}
