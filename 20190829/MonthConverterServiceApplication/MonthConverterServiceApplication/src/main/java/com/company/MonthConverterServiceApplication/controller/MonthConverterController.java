package com.company.MonthConverterServiceApplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MonthConverterController {

    @RequestMapping(value = "/day/{monthNumber}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
        public String getMonth(@PathVariable int monthNumber){

        if(monthNumber<1 || monthNumber>12) throw new IndexOutOfBoundsException();

        switch (monthNumber) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return null;
        }
    }

}
