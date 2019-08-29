package com.company.DayConverterServiceApplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;

@RestController
public class DayConverterController {

    @RequestMapping(value = "/day/{dayNumber}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
        public String getDay(@PathVariable int dayNumber){

        if(dayNumber<1 || dayNumber>7) throw new IndexOutOfBoundsException();

            switch (dayNumber) {
                case 1:
                    return "Monday";
                case 2:
                    return "Tuesday";
                case 3:
                    return "Wednesday";
                case 4:
                    return "Thursday";
                case 5:
                    return "Friday";
                case 6:
                    return "Saturday";
                case 7:
                    return "Sunday";
                default:
                    return null;
            }

        }

}
