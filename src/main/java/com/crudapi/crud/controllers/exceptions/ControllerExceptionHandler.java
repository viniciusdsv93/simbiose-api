package com.crudapi.crud.controllers.exceptions;

import com.crudapi.crud.services.exceptions.EmailAlreadyInUseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(EmailAlreadyInUseException.class)
  public ResponseEntity<StandardError> emailAlreadyInUse(EmailAlreadyInUseException e, HttpServletRequest request) {
    String error = "Email indisponível";
    HttpStatus status = HttpStatus.BAD_REQUEST;
    StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

}
