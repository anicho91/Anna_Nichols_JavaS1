package com.company.MonthConverterServiceApplication.controller;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

public class ControllerExceptionHandler {

    @ExceptionHandler(value = {NumberFormatException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<VndErrors.VndError> numberFormatException
            (NumberFormatException e, WebRequest webRequest){
        VndErrors.VndError clientError =
                new VndErrors.VndError(e.toString(), "Invalid month number");

        return new ResponseEntity<VndErrors.VndError>
                (clientError, HttpStatus.BAD_REQUEST);

    }

}
