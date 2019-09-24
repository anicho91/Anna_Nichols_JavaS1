package com.company.AnnaNicholsU1Capstone.dao;

import com.company.AnnaNicholsU1Capstone.dto.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleDaoTest {

    @Autowired
    ConsoleDao consoleDao;
    @Autowired
    GameDao gameDao;
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    TShirtDao tShirtDao;

    @Before
    public void setUp() throws Exception {
        List<Console> consoles = consoleDao.getAllConsoles();
        consoles.stream().forEach(Console -> consoleDao.deleteConsole(Console.getId()));

        List<Game> games = gameDao.getAllGames();
        games.stream().forEach(Game -> gameDao.deleteGame(Game.getId()));

        List<Invoice> invoices = invoiceDao.getAllInvoices();
        invoices.stream().forEach(Invoice -> invoiceDao.deleteInvoice(Invoice.getId()));

        List<TShirt> tShirts = tShirtDao.getAllTShirts();
        tShirts.stream().forEach(TShirt -> tShirtDao.deleteTShirt(TShirt.getId()));
    }

    @Test
    public void addGetDeleteConsole() {
        Console console = new Console();
        console.setModel("Playstation");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("Intel i7-2880k");
        console.setPrice(new BigDecimal("500.00"));
        console.setQuantity(new BigDecimal(10));

        console = consoleDao.addConsole(console);

        Console console1 = consoleDao.getConsole(console.getId());

        assertEquals(console1, console);

        consoleDao.deleteConsole(console.getId());

        console1 = consoleDao.getConsole(console.getId());

        assertNull(console1);

    }

    @Test
    public void getAllConsoles() {

        Console console = new Console();
        console.setModel("Playstation");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("Intel i7-2880k");
        console.setPrice(new BigDecimal("500.00"));
        console.setQuantity(new BigDecimal("10"));
        console = consoleDao.addConsole(console);

        console = new Console();
        console.setModel("Xbox");
        console.setManufacturer("Microsoft");
        console.setMemoryAmount("2TB");
        console.setProcessor("Intel i7-2880k");
        console.setPrice(new BigDecimal("300.00"));
        console.setQuantity(new BigDecimal("20"));
        console = consoleDao.addConsole(console);

        List<Console> consoles = consoleDao.getAllConsoles();
        assertEquals(consoles.size(), 2);

    }

    @Test
    public void updateConsole() {

        Console console = new Console();
        console.setModel("Playstation");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("Intel i7-2880k");
        console.setPrice(new BigDecimal("500.00"));
        console.setQuantity(new BigDecimal(10));
        console = consoleDao.addConsole(console);

        console.setPrice(new BigDecimal("600.00"));
        consoleDao.updateConsole(console);

        Console console1 = consoleDao.getConsole(console.getId());

        assertEquals(console1, console);
    }

    @Test
    public void getByManufacturer() {

        Console console = new Console();
        console.setModel("Playstation");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("Intel i7-2880k");
        console.setPrice(new BigDecimal("500.00"));
        console.setQuantity(new BigDecimal("10"));
        console = consoleDao.addConsole(console);

        Console console2 = new Console();
        console2.setModel("Xbox");
        console2.setManufacturer("Microsoft");
        console2.setMemoryAmount("2TB");
        console2.setProcessor("Intel i7-2880k");
        console2.setPrice(new BigDecimal("300.00"));
        console2.setQuantity(new BigDecimal("20"));
        console2 = consoleDao.addConsole(console2);

        List<Console> consoles = consoleDao.getByManufacturer(console.getManufacturer());
        assertEquals("Sony", console.getManufacturer());

    }
}