package com.crudapi.crud.services.exceptions;

public class EmailAlreadyInUseException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public EmailAlreadyInUseException(String email) {
    super("Este email já está sendo usado por outra pessoa: " + email);
  }
}
