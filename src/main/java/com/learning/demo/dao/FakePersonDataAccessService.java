package com.learning.demo.dao;

import com.learning.demo.model.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

// Compiler directive to tell that this is a repository, we can also use @Component in this place
// We mention the name for dependency injection
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID uuid, Person person) {
        DB.add(new Person(uuid, person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAllPeople() {
        return DB;
        // throw new UnsupportedOperationException("Unimplemented method 'getAllPeople'");
    }

    @Override
    public int deletePersonById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePersonById'");
    }

    @Override
    public int updatePersonById(UUID id, Person newPerson) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePersonById'");
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {

        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    

}
