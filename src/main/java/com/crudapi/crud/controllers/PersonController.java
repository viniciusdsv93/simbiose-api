package com.crudapi.crud.controllers;

import com.crudapi.crud.entities.Person;
import com.crudapi.crud.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping(value = "/pessoas")
  public ResponseEntity<List<Person>> findAll() {
    List<Person> personList = personService.findAll();
    return ResponseEntity.ok().body(personList);
  }

  @PostMapping(value = "/pessoa/{id}")
  public String insertNewPerson(@PathVariable String id) {
    return String.format("Pessoa de id %s criada", id);
  }
}
