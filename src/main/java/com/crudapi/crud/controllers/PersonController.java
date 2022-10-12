package com.crudapi.crud.controllers;

import com.crudapi.crud.controllers.DTO.PersonCreateDTO;
import com.crudapi.crud.controllers.DTO.PersonDTO;
import com.crudapi.crud.controllers.mapper.PersonMapper;
import com.crudapi.crud.entities.Person;
import com.crudapi.crud.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

  @PostMapping(value = "/pessoa")
  public ResponseEntity<PersonDTO> create(@RequestBody PersonCreateDTO personCreateDTO) {
    var person = PersonMapper.fromPersonCreateToPerson(personCreateDTO);
    var createdPerson = personService.create(person);
    var createdDto = PersonMapper.fromPersonToPersonDTO(createdPerson);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdDto.getId()).toUri();
    return ResponseEntity.created(uri).body(createdDto);
  }
}
