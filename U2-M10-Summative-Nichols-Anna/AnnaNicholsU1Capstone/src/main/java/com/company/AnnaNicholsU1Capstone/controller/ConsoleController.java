package com.company.AnnaNicholsU1Capstone.controller;

import com.company.AnnaNicholsU1Capstone.dao.ConsoleDao;
import com.company.AnnaNicholsU1Capstone.dto.Console;
import com.company.AnnaNicholsU1Capstone.service.ConsoleServiceLayer;
import com.company.AnnaNicholsU1Capstone.viewmodel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsoleController {
    
    @Autowired
    ConsoleServiceLayer consoleService;

    @RequestMapping(value="/console", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ConsoleViewModel createConsole(@RequestBody ConsoleViewModel console){

        return consoleService.addConsoleVm(console);
    }

    @RequestMapping(value="/console", method = RequestMethod.GET)
    public List<ConsoleViewModel> getAllConsoles(){

        return consoleService.getAllConsolesVm();
    }

    @RequestMapping(value="/console/{consoleId}", method = RequestMethod.GET)
    public ConsoleViewModel getConsoleById(@PathVariable int consoleId){

        return consoleService.getConsoleVm(consoleId);
    }

    @RequestMapping(value="/console/manufacturer/{manufacturer}", method = RequestMethod.GET)
    public List<ConsoleViewModel> getAllConsolesByManufacturer(@PathVariable String manufacturer){

        return consoleService.getAllConsolesByManufacturerVm(manufacturer);
    }

    @RequestMapping(value="/console", method = RequestMethod.PUT)
    public void updateConsole(@RequestBody ConsoleViewModel console){
        consoleService.updateConsoleVm(console);
    }

    @RequestMapping(value = "/console/{consoleId}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable int consoleId){
        consoleService.deleteConsoleVm(consoleId);
    }

}
