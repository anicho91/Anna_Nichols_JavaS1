package com.trilogyed.authorizationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserInfoController {

    @GetMapping("/userinfo")
    public Principal getUserInfo(Principal principal){
        System.out.println("CALLED userinfo");
        return principal;
    }

}
