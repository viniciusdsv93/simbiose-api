package com.crudapi.crud.services;

import com.crudapi.crud.entities.Person;
import com.crudapi.crud.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

  private final PersonRepository personRepository;

  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public List<Person> findAll() {
    List<Person> personList = personRepository.findAll();
    return personList;
  }
}
