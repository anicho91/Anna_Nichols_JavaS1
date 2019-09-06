package com.company.MagicEightApplication.controller;

import com.company.MagicEightApplication.model.MagicEight;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

@RestController
public class MagicEightController {

    List<MagicEight> magicList;
    Random ranNum = new Random();


    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public String postMagicEight(@RequestBody String ranQuestion) throws IOException {

        int ranNum2 = ranNum.nextInt(5);

        ObjectMapper mapper = new ObjectMapper();

        String jsonQuestion = mapper.writeValueAsString(ranQuestion);

        PrintWriter writer = new PrintWriter(new FileWriter("src/main/MagicQuestions.json", true));

        magicList = mapper.readValue(new File("src/main/MagicAns.json"),
                new TypeReference<List<MagicEight>>(){});

        String ranAns = null;

        for(int i=0; i<magicList.size(); i++){
            if(i == ranNum2){
                ranAns = magicList.get(i).getAnswer();
            }
        }

        return ranAns;
    }
}
