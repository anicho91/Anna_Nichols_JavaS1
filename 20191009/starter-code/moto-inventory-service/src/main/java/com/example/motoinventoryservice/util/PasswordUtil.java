package com.example.motoinventoryservice.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtil {

    public static void main(String[] args) {
        PasswordEncoder enc = new BCryptPasswordEncoder();

        String password = "IsThisPasswordOK?";

        String encodedPassword = enc.encode(password);

        System.out.println(encodedPassword);

    }

}
