package com.company.QuoteApplication.controller;

import com.company.QuoteApplication.model.Quote;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@RestController
public class QuoteController {

    List<Quote> quoteList;
    Random ranNum = new Random();




    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
        public String getOneQuote(String quoteAuthor) throws IOException {

        int ranNum2 = ranNum.nextInt(9);

        ObjectMapper mapper = new ObjectMapper();

        quoteList = mapper.readValue(new File("src/main/quotes.json"),
                new TypeReference<List<Quote>>(){});

        String ranQuote = null;
        String ranAuthor = null;

        for(int i=0; i<quoteList.size(); i++){
            if(i == ranNum2){
                ranQuote=quoteList.get(i).getQuote();
                ranAuthor = quoteList.get(i).getAuthor();
            }
        }

        quoteAuthor = ranQuote.concat("\n - " + ranAuthor);

        return quoteAuthor;
    }
}
