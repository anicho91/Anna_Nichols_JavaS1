package com.trilogyed.AnnaNicholsmagiceightballservice.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class Magic8BallController {

    private List<String> eightBallList = new ArrayList<>();

    private Random ran = new Random();

    public Magic8BallController(){
        eightBallList.add("No");
        eightBallList.add("Yes");
        eightBallList.add("Looking cloudy");
        eightBallList.add("Not sure");
        eightBallList.add("Absolutely!");
        eightBallList.add("Ask again");
        eightBallList.add("Ummm");
        eightBallList.add("Not a chance");
    }

    @RequestMapping(value = "/eightballanswer", method = RequestMethod.GET)
    public String getRandom8Ball(){
        int ranNum = ran.nextInt(8);
        return eightBallList.get(ranNum);
    }

}
