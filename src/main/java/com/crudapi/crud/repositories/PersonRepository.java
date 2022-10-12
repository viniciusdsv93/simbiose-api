package com.crudapi.crud.repositories;

import com.crudapi.crud.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {

  Person findByEmail(String email);
}
