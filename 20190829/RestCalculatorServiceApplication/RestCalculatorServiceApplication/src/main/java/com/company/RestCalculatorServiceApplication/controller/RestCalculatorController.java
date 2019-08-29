package com.company.RestCalculatorServiceApplication.controller;

import com.company.RestCalculatorServiceApplication.model.Calculation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RestCalculatorController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public int createAddition(@RequestBody @Valid Calculation calculation){
        int op1 = calculation.getOperand1();
        int op2 = calculation.getOperand2();

        int sum = op1 + op2;

        return sum;
    }

    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public int createSubtraction(@RequestBody @Valid Calculation calculation){
        int op1 = calculation.getOperand1();
        int op2 = calculation.getOperand2();

        int sum = op1 - op2;

        return sum;
    }

    @RequestMapping(value = "/mult", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public int createMultiplication(@RequestBody @Valid Calculation calculation){
        int op1 = calculation.getOperand1();
        int op2 = calculation.getOperand2();

        int sum = op1 * op2;

        return sum;
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public int createDivision(@RequestBody @Valid Calculation calculation){
        int op1 = calculation.getOperand1();
        int op2 = calculation.getOperand2();

        int sum = op1 / op2;

        return sum;
    }

}
