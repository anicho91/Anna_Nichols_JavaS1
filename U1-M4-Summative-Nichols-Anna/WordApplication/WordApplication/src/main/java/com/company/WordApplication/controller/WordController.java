package com.company.WordApplication.controller;

import com.company.WordApplication.model.Word;
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
public class WordController {

    List<Word> wordList;
    Random ranNum = new Random();


    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String getOneDefinition(String wordDef) throws IOException {

        int ranNum2 = ranNum.nextInt(9);

        ObjectMapper mapper = new ObjectMapper();

        wordList = mapper.readValue(new File("src/main/words.json"),
                new TypeReference<List<Word>>(){});

        String ranWord = null;
        String ranDef = null;

        for(int i=0; i<wordList.size(); i++){
            if(i == ranNum2){
                ranWord = wordList.get(i).getWord();
                ranDef = wordList.get(i).getDef();
            }
        }

        wordDef = ranWord.concat(": " + ranDef);

        return wordDef;
    }

}
