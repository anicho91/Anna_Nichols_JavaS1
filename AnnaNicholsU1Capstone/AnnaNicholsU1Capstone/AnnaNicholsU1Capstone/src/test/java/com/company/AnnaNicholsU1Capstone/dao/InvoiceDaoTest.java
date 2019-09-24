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
public class InvoiceDaoTest {

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
    public void addGetDeleteInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("Jack");
        invoice.setStreet("13 parway");
        invoice.setCity("Atlanta");
        invoice.setState("GA");
        invoice.setZipcode("30109");
        invoice.setItemType("Console");
        invoice.setItemId(3);
        invoice.setQuantity(5);
        invoice.setUnitPrice(new BigDecimal("33.44"));
        invoice.setSubtotal(new BigDecimal("50.02"));
        invoice.setTax(new BigDecimal(".04"));
        invoice.setProcessingFee(new BigDecimal("1.99"));
        invoice.setTotal(new BigDecimal("60.99"));

        invoice = invoiceDao.addInvoice(invoice);

        Invoice invoice1 = invoiceDao.getInvoice(invoice.getId());

        assertEquals(invoice1, invoice);

        invoiceDao.deleteInvoice(invoice.getId());

        invoice1 = invoiceDao.getInvoice(invoice.getId());

        assertNull(invoice1);
    }

    @Test
    public void getAllInvoices() {
        Invoice invoice = new Invoice();
        invoice.setName("Jack");
        invoice.setStreet("13 parway");
        invoice.setCity("Atlanta");
        invoice.setState("GA");
        invoice.setZipcode("30109");
        invoice.setItemType("Console");
        invoice.setItemId(3);
        invoice.setQuantity(5);
        invoice.setUnitPrice(new BigDecimal("33.44"));
        invoice.setSubtotal(new BigDecimal("50.02"));
        invoice.setTax(new BigDecimal(".04"));
        invoice.setProcessingFee(new BigDecimal("1.99"));
        invoice.setTotal(new BigDecimal("60.99"));
        invoice = invoiceDao.addInvoice(invoice);

        invoice = new Invoice();
        invoice.setName("Peggy");
        invoice.setStreet("232 Downing");
        invoice.setCity("Atlanta");
        invoice.setState("GA");
        invoice.setZipcode("30159");
        invoice.setItemType("Game");
        invoice.setItemId(2);
        invoice.setQuantity(1);
        invoice.setUnitPrice(new BigDecimal("33.44"));
        invoice.setSubtotal(new BigDecimal("50.02"));
        invoice.setTax(new BigDecimal(".04"));
        invoice.setProcessingFee(new BigDecimal("1.99"));
        invoice.setTotal(new BigDecimal("60.99"));
        invoice = invoiceDao.addInvoice(invoice);

        List<Invoice> invoices = invoiceDao.getAllInvoices();
        assertEquals(invoices.size(), 2);
    }
    
}