package com.learning.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.demo.model.Person;

@Repository("postgres")
public class PostGresAccessService {

    @Autowired
    private PostGresRepository repository;

    public int insertPerson(UUID uuid, Person person) {
        Person newPerson = new Person(uuid, person.getName());
        repository.save(newPerson);
        return 1;
    }
    public int insertPersonDefault(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    public List<Person> getAllPeople() {
        return repository.findAll();
    }

    public int deletePersonById(UUID id) {
        repository.deleteById(id);
        return 1;
    }

    public int updatePersonById(UUID id, Person newPerson) {
        if (repository.existsById(id)) {
            Person person = repository.findById(id).get();
            person.setName(person.getName());
            return 1;
        }
        return 0;
    }

    public Optional<Person> getPersonById(UUID id) {
        return repository.findById(id);
    }

}
