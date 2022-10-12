package com.crudapi.crud.controllers.mapper;

import com.crudapi.crud.controllers.DTO.PersonCreateDTO;
import com.crudapi.crud.entities.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

  public static Person fromPersonCreateToPerson(PersonCreateDTO personCreateDTO) {
    return new Person(null, personCreateDTO.getName(), personCreateDTO.getEmail(), personCreateDTO.getBirthday());
  }
}
