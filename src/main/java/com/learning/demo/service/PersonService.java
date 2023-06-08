package com.learning.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.learning.demo.dao.PersonDao;
import com.learning.demo.dao.PostGresAccessService;
import com.learning.demo.model.Person;

@Service
public class PersonService {
    
    // The person data access service we are going to use
    private final PostGresAccessService personDao;

    // In this case we are using the fakeDao implementation of the PersonDao interface
    // Autowired to indicate dependency injection
    @Autowired
    public PersonService(PostGresAccessService personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person newPerson) {
        this.personDao.insertPersonDefault(newPerson);
        return 0;
    }

    public List<Person> returnAllPeople() {
        return this.personDao.getAllPeople();
    }

    public Optional<Person> getPersonById(UUID id) {
        return this.personDao.getPersonById(id);
    }

    public int deletePersonById(UUID uid) {
        return this.personDao.deletePersonById(uid);
    }

    public int updatePersonById(UUID uid, Person newPerson) {
        return this.personDao.updatePersonById(uid, newPerson);
    }
}
