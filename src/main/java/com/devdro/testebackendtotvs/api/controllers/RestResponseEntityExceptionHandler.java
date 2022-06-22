package com.devdro.testebackendtotvs.api.controllers;

import com.devdro.testebackendtotvs.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({ ResourceNotFoundException.class })
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<?> handleNotFoundException(Exception exception, WebRequest request) {
    return ResponseEntity.notFound().build();
  }
}
