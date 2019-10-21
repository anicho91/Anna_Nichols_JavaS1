package com.company.AnnaNicholsU1Capstone.controller;

import com.company.AnnaNicholsU1Capstone.dao.TShirtDao;
import com.company.AnnaNicholsU1Capstone.dto.TShirt;
import com.company.AnnaNicholsU1Capstone.service.TShirtServiceLayer;
import com.company.AnnaNicholsU1Capstone.viewmodel.TShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TShirtController {

    @Autowired
    TShirtServiceLayer tShirtService;

    @RequestMapping(value="/tshirt", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public TShirtViewModel createTShirt(@RequestBody TShirtViewModel tshirt){
        return tShirtService.addTShirtVm(tshirt);
    }

    @RequestMapping(value="/tshirt", method = RequestMethod.GET)
    public List<TShirtViewModel> getAllTShirts(){

        return tShirtService.getAllTShirtsVm();
    }

    @RequestMapping(value="/tshirt/{tshirtId}", method = RequestMethod.GET)
    public TShirtViewModel getTShirtById(@PathVariable int tshirtId){

        return tShirtService.getTShirtVm(tshirtId);
    }

    @RequestMapping(value="/tshirt/color/{color}", method = RequestMethod.GET)
    public List<TShirtViewModel> getTShirtByColor(@PathVariable String color){
        return tShirtService.getAllTShirtsByColorVm(color);
    }

    @RequestMapping(value="/tshirt/size/{size}", method = RequestMethod.GET)
    public List<TShirtViewModel> getTShirtBySize(@PathVariable String size){
        return tShirtService.getAllTShirtsBySizeVm(size);
    }

    @RequestMapping(value="/tshirt", method = RequestMethod.PUT)
    public void updateTShirt(@RequestBody TShirtViewModel tshirt){
        tShirtService.updateTShirtVm(tshirt);
    }

    @RequestMapping(value = "/tshirt/{tshirtId}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable int tshirtId){
        tShirtService.deleteTShirtVm(tshirtId);
    }
}
