package com.company.WeatherWebServiceApplication.controllers;

import com.company.WeatherWebServiceApplication.model.Temperature;
import com.company.WeatherWebServiceApplication.model.Weather;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherServiceController {

    @RequestMapping(value = "/temp/{zipcode}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Temperature getTemperature(@PathVariable int zipcode){
        Temperature newTemp = new Temperature();
        newTemp.setFahrenheit(85);
        newTemp.setCelsius(30);

        return newTemp;
    }

    @RequestMapping(value = "/conditions/{zipcode}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Weather getWeather(@PathVariable int zipcode){
        Weather newWeather = new Weather();

        newWeather.setTemperatureList(85, 30);
        newWeather.setWindSpeed(5);
        newWeather.setWindDirection("West");
        newWeather.setSkies("Cloudy");
        newWeather.setPrecipitation(3);

        return newWeather;
    }

}
