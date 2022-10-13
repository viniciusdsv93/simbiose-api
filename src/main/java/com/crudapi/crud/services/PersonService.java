package com.crudapi.crud.services;

import com.crudapi.crud.controllers.DTO.PersonCreateDTO;
import com.crudapi.crud.entities.Person;
import com.crudapi.crud.repositories.PersonRepository;
import com.crudapi.crud.services.exceptions.EmailAlreadyInUseException;
import com.crudapi.crud.services.exceptions.PersonNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
      return person;
    }
    else {
      throw new EmailAlreadyInUseException(person.getEmail());
    }
  }

  public Person findById(String id) {
    Optional<Person> person = personRepository.findById(id);
    return person.orElseThrow(() -> new PersonNotFoundException(id));
  }

  public void delete(String id) {
    try {
      personRepository.deleteById(id);
    }
    catch (EmptyResultDataAccessException e) {
      throw new PersonNotFoundException(id);
    }
  }

  public Person update(String id, PersonCreateDTO personCreateDTO) {
    Person person = findById(id);
    if (personCreateDTO.getEmail().equals(person.getEmail()) || (!personCreateDTO.getEmail().equals(person.getEmail()) && personRepository.findByEmail(personCreateDTO.getEmail()) == null)) {
      person.setName(personCreateDTO.getName());
      person.setEmail(personCreateDTO.getEmail());
      person.setBirthday(personCreateDTO.getBirthday());
      personRepository.save(person);
      return person;
    }
    else {
      throw new EmailAlreadyInUseException(personCreateDTO.getEmail());
    }
  }
}
