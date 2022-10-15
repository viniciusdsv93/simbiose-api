package com.crudapi.crud.controllers;

import com.crudapi.crud.controllers.DTO.PersonCreateDTO;
import com.crudapi.crud.controllers.DTO.PersonDTO;
import com.crudapi.crud.controllers.mapper.PersonMapper;
import com.crudapi.crud.entities.Person;
import com.crudapi.crud.services.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@Api(tags = "Controller de Pessoas")
public class PersonController {

  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @CrossOrigin(origins = "*")
  @GetMapping(value = "/pessoas")
  @ApiOperation("Buscar todas as pessoas")
  public ResponseEntity<List<PersonDTO>> findAll() {
    var personList = personService.findAll();
    var personDTOList = PersonMapper.fromPersonToPersonDTOList(personList);
    return ResponseEntity.ok().body(personDTOList);
  }

  @CrossOrigin(origins = "*")
  @PostMapping(value = "/pessoa")
  @ApiOperation("Cadastrar uma pessoa")
  public ResponseEntity<PersonDTO> create(@RequestBody PersonCreateDTO personCreateDTO) {
    var person = PersonMapper.fromPersonCreateToPerson(personCreateDTO);
    var createdPerson = personService.create(person);
    var createdDto = PersonMapper.fromPersonToPersonDTO(createdPerson);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdDto.getId()).toUri();
    return ResponseEntity.created(uri).body(createdDto);
  }

  @CrossOrigin(origins = "*")
  @GetMapping(value = "/pessoa/{id}")
  @ApiOperation("Encontrar uma pessoa específica")
  public ResponseEntity<PersonDTO> findById(@PathVariable String id) {
    Person person = personService.findById(id);
    var personDto = PersonMapper.fromPersonToPersonDTO(person);
    return ResponseEntity.ok().body(personDto);
  }

  @CrossOrigin(origins = "*")
  @DeleteMapping(value = "/pessoa/{id}")
  @ApiOperation("Deletar uma pessoa")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    personService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @CrossOrigin(origins = "*")
  @PutMapping(value = "/pessoa/{id}")
  @ApiOperation("Alterar dados de uma pessoa")
  public ResponseEntity<PersonDTO> update(@PathVariable String id, @RequestBody PersonCreateDTO personCreateDTO) {
    Person modifiedPerson = personService.update(id, personCreateDTO);
    PersonDTO modifiedPersonDto = PersonMapper.fromPersonToPersonDTO(modifiedPerson);
    return ResponseEntity.ok().body(modifiedPersonDto);
  }
}
