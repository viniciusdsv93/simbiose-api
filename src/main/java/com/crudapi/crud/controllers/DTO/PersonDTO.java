package com.crudapi.crud.controllers.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonDTO {

  private String id;
  private String name;
  private String email;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate birthday;

  public PersonDTO() {

  }

  public PersonDTO(String id, String name, String email, LocalDate birthday) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.birthday = birthday;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }
}
