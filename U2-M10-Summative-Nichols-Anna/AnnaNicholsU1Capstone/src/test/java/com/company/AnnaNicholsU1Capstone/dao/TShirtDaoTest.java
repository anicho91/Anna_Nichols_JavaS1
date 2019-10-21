package com.company.AnnaNicholsU1Capstone.dao;

import com.company.AnnaNicholsU1Capstone.dto.Console;
import com.company.AnnaNicholsU1Capstone.dto.Game;
import com.company.AnnaNicholsU1Capstone.dto.Invoice;
import com.company.AnnaNicholsU1Capstone.dto.TShirt;
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
public class TShirtDaoTest {

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
    public void addGetDeleteTShirt() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("M");
        tShirt.setColor("red");
        tShirt.setDescription("Shirt");
        tShirt.setPrice(new BigDecimal("10.01"));
        tShirt.setQuantity(new BigDecimal("2"));

        tShirt = tShirtDao.addTShirt(tShirt);

        TShirt tShirt1 = tShirtDao.getTShirt(tShirt.getId());

        assertEquals(tShirt1, tShirt);

        tShirtDao.deleteTShirt(tShirt.getId());

        tShirt1 = tShirtDao.getTShirt(tShirt.getId());

        assertNull(tShirt1);
    }

    @Test
    public void getAllTShirts() {

        TShirt tShirt = new TShirt();
        tShirt.setSize("M");
        tShirt.setColor("Red");
        tShirt.setDescription("Shirt");
        tShirt.setPrice(new BigDecimal("10.00"));
        tShirt.setQuantity(new BigDecimal("6"));
        tShirt = tShirtDao.addTShirt(tShirt);

        tShirt = new TShirt();
        tShirt.setSize("L");
        tShirt.setColor("Blue");
        tShirt.setDescription("Shirt");
        tShirt.setPrice(new BigDecimal("10.00"));
        tShirt.setQuantity(new BigDecimal("6"));
        tShirt = tShirtDao.addTShirt(tShirt);

        List<TShirt> tShirts = tShirtDao.getAllTShirts();
        assertEquals(tShirts.size(), 2);
    }

    @Test
    public void updateTShirt() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("M");
        tShirt.setColor("Red");
        tShirt.setDescription("Shirt");
        tShirt.setPrice(new BigDecimal("10.00"));
        tShirt.setQuantity(new BigDecimal("6"));
        tShirt = tShirtDao.addTShirt(tShirt);

        tShirt.setQuantity(new BigDecimal("3"));
        tShirtDao.updateTShirt(tShirt);

        TShirt tShirt1 = tShirtDao.getTShirt(tShirt.getId());

        assertEquals(tShirt1, tShirt);
    }

    @Test
    public void getByColor() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("M");
        tShirt.setColor("Red");
        tShirt.setDescription("Shirt");
        tShirt.setPrice(new BigDecimal("10.00"));
        tShirt.setQuantity(new BigDecimal("2"));
        tShirt = tShirtDao.addTShirt(tShirt);

        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("L");
        tShirt2.setColor("Blue");
        tShirt2.setDescription("Shirt");
        tShirt2.setPrice(new BigDecimal("10.00"));
        tShirt2.setQuantity(new BigDecimal("2"));
        tShirt2 = tShirtDao.addTShirt(tShirt2);

        List<TShirt> tShirts = tShirtDao.getByColor(tShirt2.getColor());
        assertEquals("Blue", tShirt2.getColor());
    }

    @Test
    public void getBySize() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("M");
        tShirt.setColor("Red");
        tShirt.setDescription("Shirt");
        tShirt.setPrice(new BigDecimal("10.00"));
        tShirt.setQuantity(new BigDecimal("2"));
        tShirt = tShirtDao.addTShirt(tShirt);

        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("L");
        tShirt2.setColor("Blue");
        tShirt2.setDescription("Shirt");
        tShirt2.setPrice(new BigDecimal("10.00"));
        tShirt2.setQuantity(new BigDecimal("2"));
        tShirt2 = tShirtDao.addTShirt(tShirt2);

        List<TShirt> tShirts = tShirtDao.getBySize(tShirt2.getSize());
        assertEquals("L", tShirt2.getSize());
    }
}