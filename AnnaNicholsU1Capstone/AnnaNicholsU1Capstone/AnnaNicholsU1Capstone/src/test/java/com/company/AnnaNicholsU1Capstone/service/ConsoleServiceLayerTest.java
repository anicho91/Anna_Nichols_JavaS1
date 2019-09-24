package com.company.AnnaNicholsU1Capstone.service;

import com.company.AnnaNicholsU1Capstone.dao.ConsoleDao;
import com.company.AnnaNicholsU1Capstone.dto.Console;
import com.company.AnnaNicholsU1Capstone.viewmodel.ConsoleViewModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ConsoleServiceLayerTest {
    private ConsoleServiceLayer consoleService;
    private ConsoleDao consoleDao;
    private ConsoleViewDao consoleViewDao;

    private void setupConsoleMock(){
        consoleDao = mock(ConsoleDao.class);

        Console console = new Console();
        console.setId(2);
        console.setModel("Playstation");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("Intel i7-2880k");
        console.setPrice(new BigDecimal("500.00"));
        console.setQuantity(new BigDecimal(10));

        Console console2 = new Console();
        console2.setModel("Playstation");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("2TB");
        console2.setProcessor("Intel i7-2880k");
        console2.setPrice(new BigDecimal("500.00"));
        console2.setQuantity(new BigDecimal(10));

        List<Console> consoles = new ArrayList<>();
        consoles.add(console);

        doReturn(console).when(consoleDao).addConsole(console2);
        doReturn(console).when(consoleDao).getConsole(2);
        doReturn(consoles).when(consoleDao).getAllConsoles();
    }

    @Before
    public void setUp() throws Exception {
        setupConsoleMock();

        consoleService = new ConsoleServiceLayer(consoleDao);
    }

    @Test
    public void addGetGetAllConsoleVm() {
        ConsoleViewModel console = new ConsoleViewModel();
        console.setModel("Playstation");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("Intel i7-2880k");
        console.setPrice(new BigDecimal("500.00"));
        console.setQuantity(new BigDecimal(10));
        console = consoleService.addConsoleVm(console);

        ConsoleViewModel fromService = consoleService.getConsoleVm(console.getId());
        assertEquals(console, fromService);

        List<ConsoleViewModel> consoles = consoleService.getAllConsolesVm();
        assertEquals(1, consoles.size());
        assertEquals(console, consoles.get(0));
    }

    @Test
    public void updateConsoleVm() {

        ConsoleViewModel console = new ConsoleViewModel();
        console.setId(2);
        console.setModel("Playstation");
        console.setManufacturer("Sony");
        console.setMemoryAmount("3TB");
        console.setProcessor("Intel i7-2880k");
        console.setPrice(new BigDecimal("500.00"));
        console.setQuantity(new BigDecimal(10));

        ArgumentCaptor<Console> consoleCaptor = ArgumentCaptor.forClass(Console.class);

        doNothing().when(consoleDao).updateConsole(consoleCaptor.capture());

        consoleService.updateConsoleVm(console);
        verify(consoleDao, times(1)).updateConsole(consoleCaptor.getValue());

        Console console2 = consoleCaptor.getValue();

        assertEquals(console.getModel(), console2.getModel());

    }

    @Test
    public void deleteConsoleVm() {

        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(consoleDao).deleteConsole(integerCaptor.capture());

        consoleService.deleteConsoleVm(2);
        verify(consoleDao, times(1)).deleteConsole(integerCaptor.getValue());
        assertEquals(2, integerCaptor.getValue().intValue());
    }


    @Test
    public void getAllConsolesByManufacturerVm() {
        ConsoleViewModel console = new ConsoleViewModel();
        console.setModel("Playstation");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("Intel i7-2880k");
        console.setPrice(new BigDecimal("500.00"));
        console.setQuantity(new BigDecimal(10));
        console = consoleService.addConsoleVm(console);

        List<ConsoleViewModel> consoles = consoleService.getAllConsolesVm();
        consoleService.getAllConsolesByManufacturerVm(console.getManufacturer());
        assertEquals("Sony", console.getManufacturer());
        assertEquals(console, consoles.get(0));
    }
}