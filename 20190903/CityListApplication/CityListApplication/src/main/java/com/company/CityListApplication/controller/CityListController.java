package com.company.CityListApplication.controller;

import com.company.CityListApplication.model.City;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CityListController {

    private List<City> cityList = new ArrayList<>();

    @RequestMapping(value = "/city", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public String postCity(@Valid City city, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }else {
            cityList.add(city);
        }

        return "redirect:/results";
    }

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<City> getCityList(City city){
        return cityList;
    }

    @RequestMapping(value = "/city/{name}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteCity(@PathVariable String name) {

        boolean exists = false;
        int indexLoc = 0;

        for (City city: cityList) {

            if (city.getName().equalsIgnoreCase(name)) {
                exists = true;
                break;
            }

            indexLoc ++;

        }

        if (exists){
            cityList.remove(indexLoc);
        }

    }

    @RequestMapping(value = "/city/{name}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public City getOneCity(@PathVariable String name){

        for(City city: cityList){
            if(city.getName().equalsIgnoreCase(name)){
                return city;
            }
        }

        return null;
    }
}
