package com.company.AnnaNicholsU1Capstone.controller;

import org.springframework.security.test.context.support.WithMockUser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithMockUser(username = "admin", authorities = "ADMIN")
@interface WithMockAdmin {
}
