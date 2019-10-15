package com.company.circuitbreakerreading.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

//SERVICE LAYER
//USES RestTemplate to get information from our bookstore application
@Service
public class BookService {

    private final RestTemplate restTemplate;

    public BookService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //In case the connection to the bookstore application fails
    //HystrixCommand using fallback method reliable will create a placeholder
    //to give to users instead of having the call fail
    @HystrixCommand(fallbackMethod = "reliable")
    public String readingList(){
        //getting information from the bookstore application at the uri path of recommended
        URI uri = URI.create("http://localhost:8090/recommended");

        return this.restTemplate.getForObject(uri, String.class);
    }

    //Creating placeholder to be returned in case of failure
    public String reliable(){
        return "Cloud Native Java (O'Reilly)";
    }
}
