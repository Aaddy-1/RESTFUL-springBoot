package com.learning.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.demo.model.Person;

@Repository
public interface PostGresRepository extends JpaRepository<Person, UUID> {

}
