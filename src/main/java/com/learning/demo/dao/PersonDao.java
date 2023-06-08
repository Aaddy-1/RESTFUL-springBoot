package com.learning.demo.dao;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.demo.model.Person;



@Repository
public interface PersonDao {
    public int insertPerson(UUID uuid, Person person);
    
    default int insertPersonDefault(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    public List<Person> getAllPeople();

    public int deletePersonById(UUID id);

    public int updatePersonById(UUID id, Person newPerson);

    public Optional<Person> getPersonById(UUID id);
}

