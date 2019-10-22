package com.company.AnnaNicholsU1Capstone.service;

import com.company.AnnaNicholsU1Capstone.dao.ConsoleDao;
import com.company.AnnaNicholsU1Capstone.dto.Console;
import com.company.AnnaNicholsU1Capstone.viewmodel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConsoleServiceLayer implements ConsoleViewDao{

    private ConsoleDao consoleDao;

    @Autowired
    public ConsoleServiceLayer(ConsoleDao consoleDao) {
        this.consoleDao = consoleDao;
    }

    @Override
    public ConsoleViewModel addConsoleVm(ConsoleViewModel consoleViewModel) {

        Console console = new Console();
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());
        console = consoleDao.addConsole(console);

        consoleViewModel.setId(console.getId());

        return consoleViewModel;

    }

    @Override
    public ConsoleViewModel getConsoleVm(int consoleId) {

        Console console = consoleDao.getConsole(consoleId);
        return buildConsoleViewModel(console);

    }

    @Override
    public List<ConsoleViewModel> getAllConsolesVm() {
        List<Console> consoles = consoleDao.getAllConsoles();

        List<ConsoleViewModel> cVMList = new ArrayList<>();

        for(Console console : consoles){
            ConsoleViewModel consoleViewModel = buildConsoleViewModel(console);
            cVMList.add(consoleViewModel);
        }

        return cVMList;
    }

    @Override
    public void updateConsoleVm(ConsoleViewModel consoleViewModel) {

        Console console = new Console();
        console.setId(consoleViewModel.getId());
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());
        consoleDao.updateConsole(console);

    }

    @Override
    public void deleteConsoleVm(int consoleId) {

        consoleDao.deleteConsole(consoleId);

    }

    @Override
    public List<ConsoleViewModel> getAllConsolesByManufacturerVm(String manufacturer) {
        List<Console> consoles = consoleDao.getByManufacturer(manufacturer);

        List<ConsoleViewModel> cVMList = new ArrayList<>();

        for(Console console : consoles){
            ConsoleViewModel consoleViewModel = buildConsoleViewModel(console);
            cVMList.add(consoleViewModel);
        }

        return cVMList;
    }

    private ConsoleViewModel buildConsoleViewModel(Console console){
        ConsoleViewModel consoleViewModel = new ConsoleViewModel();
        consoleViewModel.setId(console.getId());
        consoleViewModel.setModel(console.getModel());
        consoleViewModel.setManufacturer(console.getManufacturer());
        consoleViewModel.setMemoryAmount(console.getMemoryAmount());
        consoleViewModel.setProcessor(console.getProcessor());
        consoleViewModel.setPrice(console.getPrice());
        consoleViewModel.setQuantity(console.getQuantity());

        return consoleViewModel;
    }
}
