package com.trilogyed.AnnaNicholsrandomquoteservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class RandomQuoteController {
    Random ran = new Random();


    String ranQuote = null;

    @Value("${quote}")
    private String quote;

    public String getQuote(){
        int ranNum = ran.nextInt(8);
        String newQuote[] = new String[8];
        newQuote = quote.split("&&");


        for(int i=0; i<newQuote.length; i++){
            if(i==ranNum){
                ranQuote = newQuote[i];
            }
        }

        return ranQuote;
    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    public String getQuoteController(){
        getQuote();
        return ranQuote;
    }
}

