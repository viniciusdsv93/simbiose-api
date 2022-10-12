package com.crudapi.crud.controllers;

import com.crudapi.crud.controllers.DTO.PersonCreateDTO;
import com.crudapi.crud.controllers.mapper.PersonMapper;
import com.crudapi.crud.entities.Person;
import com.crudapi.crud.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping
  public ResponseEntity<Person> create(@RequestBody PersonCreateDTO personCreateDTO) {
    var person = PersonMapper.fromPersonCreateToPerson(personCreateDTO);
    return null;
  }
}
