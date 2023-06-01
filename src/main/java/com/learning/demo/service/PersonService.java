package com.learning.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.learning.demo.dao.PersonDao;

import com.learning.demo.model.Person;

@Service
public class PersonService {
    
    // The person data access service we are going to use
    private final PersonDao personDao;

    // In this case we are using the fakeDao implementation of the PersonDao interface
    // Autowired to indicate dependency injection
    @Autowired
    public PersonService(@Qualifier("fakeDao")PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person newPerson) {
        this.personDao.insertPersonDefault(newPerson);
        return 0;
    }
}
