package com.trilogyed.stwitter.controller;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;

@ControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<VndErrors.VndError> exception
            (Exception e, WebRequest webRequest){
        VndErrors.VndError clientError =
                new VndErrors.VndError(e.toString(), "Invalid Entry");

        return new ResponseEntity<VndErrors.VndError>
                (clientError, HttpStatus.BAD_REQUEST);

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {IOException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<VndErrors.VndError> notFoundException
            (IOException e, WebRequest webRequest){
        VndErrors.VndError notFoundError =
                new VndErrors.VndError(e.toString(), "Not Found");

        return new ResponseEntity<VndErrors.VndError>
                (notFoundError, HttpStatus.NOT_FOUND);
    }

}
