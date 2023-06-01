package com.learning.demo.dao;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.learning.demo.model.Person;

@Repository
public interface PersonDao {
    public int insertPerson(UUID uuid, Person person);
    
    default int insertPersonDefault(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }
}

