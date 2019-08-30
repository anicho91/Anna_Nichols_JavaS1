package com.company.DayConverterServiceApplication.controller;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class ControllerExceptions {

    @ExceptionHandler(value = {NumberFormatException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<VndErrors.VndError> numberFormatException
            (NumberFormatException e, WebRequest webRequest){
        VndErrors.VndError clientError =
                new VndErrors.VndError(e.toString(), "Invalid day number");

        return new ResponseEntity<VndErrors.VndError>
                (clientError, HttpStatus.BAD_REQUEST);

    }

}
