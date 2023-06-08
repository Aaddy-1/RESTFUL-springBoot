// The model package contains all of the data structures/entities that can be used in our application
// They also encapsulate the business logic in applications

package com.learning.demo.model;

import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "anime")
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID uid;
    private String name;
    // We mention that they are json properties so that we can make objects from post requests

    public Person(){};

    public Person(@JsonProperty("id") UUID uid, 
    @JsonProperty("name") String name) {
        this.uid = uid;
        this.name = name;
    }

    public UUID getUid() {
        return this.uid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

}
