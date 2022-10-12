package com.crudapi.crud.services;

import com.crudapi.crud.entities.Person;
import com.crudapi.crud.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

  private final PersonRepository personRepository;

  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  private String getUUID() {
    return UUID.randomUUID().toString().replace("-", "");
  }

  public List<Person> findAll() {
    List<Person> personList = personRepository.findAll();
    return personList;
  }

  public Person create(Person person) {
    if (personRepository.findByEmail(person.getEmail()) == null) {
      String uuid = getUUID();
      person.setId(uuid);
      personRepository.save(person);
      System.out.println("email disponível");
      return person;
    }
    else {
      //todo implement throw error
      System.out.println("email já em uso");
      return person;
    }
  }
}
