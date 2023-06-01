// The model package contains all of the data structures/entities that can be used in our application
// They also encapsulate the business logic in applications

package com.learning.demo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    
    private final UUID id;
    private final String name;
    // We mention that they are json properties so that we can make objects from post requestsx
    public Person(@JsonProperty("id")UUID id, 
    @JsonProperty("name")String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

}
