package com.company.AnnaNicholsU1M5Summative.controllers;

import com.company.AnnaNicholsU1M5Summative.dao.PublisherDao;
import com.company.AnnaNicholsU1M5Summative.dto.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PublisherController {

    @Autowired
    PublisherDao publisherDao;

    private List<Publisher> publisherList = new ArrayList<>();

    @RequestMapping(value = "/publisher", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Publisher postPublisher(@RequestBody @Valid Publisher publisher) {
        return publisherDao.addPublisher(publisher);
        
    }

    @RequestMapping(value = "/publisher", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Publisher> getPublishers() {

        return publisherDao.getAllPublishers();
    }

    @RequestMapping(value = "/publisher/{publisherId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Publisher getOnePublisher(@PathVariable int publisherId) {
        return publisherDao.getPublisher(publisherId);
    }

    @RequestMapping(value = "/publisher/{publisherId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deletePublisher(@PathVariable int publisherId) {

        publisherDao.deletePublisher(publisherId);
    }

    @RequestMapping(value = "/publisher/{publisherId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updatePublisher(@PathVariable int publisherId, @RequestBody Publisher publisher) {

        publisher = publisherDao.getPublisher(publisherId);
        publisher.setName(publisher.getName());
        publisher.setStreet(publisher.getStreet());
        publisher.setCity(publisher.getStreet());
        publisher.setState(publisher.getState());
        publisher.setPostalCode(publisher.getPostalCode());
        publisher.setPhone(publisher.getPhone());
        publisher.setEmail(publisher.getEmail());

        publisherDao.updatePublisher(publisher);
    }
    
}
