package com.company.greetingservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingControllerImpl implements GreetingController{
    @Override
    public String greeting(@PathVariable("username") String username) {
        //%s adds variable to the String
        return String.format("Hello %s!", username);
    }
}
