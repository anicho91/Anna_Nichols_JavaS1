package com.company.HelloServiceApplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloServiceController {

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String hello(@PathVariable String name){
        return "Hello, " + name;
    }

}
