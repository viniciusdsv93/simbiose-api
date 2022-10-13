package com.crudapi.crud.services.exceptions;

public class PersonNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public PersonNotFoundException(String id) {
    super("Pessoa não encontrada com o id: " + id);
  }
}
