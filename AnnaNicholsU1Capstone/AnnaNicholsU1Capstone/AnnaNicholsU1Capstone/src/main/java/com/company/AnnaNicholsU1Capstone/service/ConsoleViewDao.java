package com.company.AnnaNicholsU1Capstone.service;

import com.company.AnnaNicholsU1Capstone.viewmodel.ConsoleViewModel;

import java.util.List;

public interface ConsoleViewDao {

    ConsoleViewModel addConsoleVm(ConsoleViewModel consoleViewModel);

    ConsoleViewModel getConsoleVm(int consoleId);

    List<ConsoleViewModel> getAllConsolesVm();

    void updateConsoleVm(ConsoleViewModel consoleViewModel);

    void deleteConsoleVm(int consoleId);

    List<ConsoleViewModel> getAllConsolesByManufacturerVm(String manufacturer);
    
}
