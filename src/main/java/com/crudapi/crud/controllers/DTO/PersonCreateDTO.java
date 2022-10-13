package com.crudapi.crud.controllers.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import springfox.documentation.annotations.ApiIgnore;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonCreateDTO {

  private String name;
  private String email;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate birthday;

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
