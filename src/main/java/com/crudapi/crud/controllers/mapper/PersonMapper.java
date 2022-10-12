package com.crudapi.crud.controllers.mapper;

import com.crudapi.crud.controllers.DTO.PersonCreateDTO;
import com.crudapi.crud.controllers.DTO.PersonDTO;
import com.crudapi.crud.entities.Person;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper {

  public static Person fromPersonCreateToPerson(PersonCreateDTO personCreateDTO) {
    return new Person(null, personCreateDTO.getName(), personCreateDTO.getEmail(), personCreateDTO.getBirthday());
  }

  public static PersonDTO fromPersonToPersonDTO(Person createdPerson) {
//    DateTimeFormatter dtm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//    System.out.println("formatDate " + dtm.format(createdPerson.getBirthday()));
    return new PersonDTO(createdPerson.getId(), createdPerson.getName(), createdPerson.getEmail(), createdPerson.getBirthday());
  }

  public static List<PersonDTO> fromPersonToPersonDTOList(List<Person> personList) {
    return personList.stream().map(item -> fromPersonToPersonDTO(item)).collect(Collectors.toList());
  }
}
