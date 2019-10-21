package com.company.AnnaNicholsU1Capstone.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class ExceptionHandlingController {

    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<Object> outOfRangeException(IllegalArgumentException e, WebRequest request) {
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(e, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    @ExceptionHandler(ClassNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> NotFoundException(ClassNotFoundException e, WebRequest request) {
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<Object> cityValidationError(MethodArgumentNotValidException e, WebRequest request) {

        ResponseEntity<Object> responseEntity = new ResponseEntity<>(e, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;

    }

}
