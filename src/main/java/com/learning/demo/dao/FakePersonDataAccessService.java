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
        // We use optional in case the person to be deleted is not in the db
        Optional<Person> personToBeDeleted = getPersonById(id);
        // return 0 if they dont exist
        if (personToBeDeleted.isEmpty()) {
            return 0;
        }
        // we use the .get() method to get the actual person object
        DB.remove(personToBeDeleted.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID uid, Person newPerson) {
        Optional<Person> personToBeUpdated = getPersonById(uid);
        if (personToBeUpdated.isEmpty()) {
            return 0;
        }
        // Get the index of the element we are trying to update
        int index = DB.indexOf(personToBeUpdated.get());

        if (newPerson.getUid() == null) {
            DB.set(index, new Person(uid, newPerson.getName()));
            return 1;
        }
        
        DB.set(index, newPerson); 
        return 1;
    }

    @Override
    public Optional<Person> getPersonById(UUID uid) {
        return DB.stream().filter(person -> person.getUid().equals(uid)).findFirst();
    }

    

}
