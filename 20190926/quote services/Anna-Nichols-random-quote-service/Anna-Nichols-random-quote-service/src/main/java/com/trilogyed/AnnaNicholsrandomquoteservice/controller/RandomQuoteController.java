package com.trilogyed.AnnaNicholsrandomquoteservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class RandomQuoteController {
    @Autowired
    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${magicEightBallAns}")
    private String magicEightBallAns;

    @Value("${serviceProtocol}")
    private String serviceProtocol;

    @Value("${servicePath}")
    private String servicePath;


    @Value("${quote}")
    private String quote;

    Random ran = new Random();

    String ranQuote = null;

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

    @RequestMapping(value = "/answerme", method = RequestMethod.GET)
    public String eightBallAnswer(){
        List<ServiceInstance> instances = discoveryClient.getInstances(magicEightBallAns);

        String magic8Uri = serviceProtocol + instances.get(0).getHost() + ":" + instances.get(0).getPort() + servicePath;

        String answer = restTemplate.getForObject(magic8Uri, String.class);

        return answer;
    }
}

