package com.company.AnnaNicholsU1Capstone.service;

import com.company.AnnaNicholsU1Capstone.dao.*;
import com.company.AnnaNicholsU1Capstone.dto.Console;
import com.company.AnnaNicholsU1Capstone.dto.Game;
import com.company.AnnaNicholsU1Capstone.dto.Invoice;
import com.company.AnnaNicholsU1Capstone.dto.TShirt;
import com.company.AnnaNicholsU1Capstone.viewmodel.ConsoleViewModel;
import com.company.AnnaNicholsU1Capstone.viewmodel.GameViewModel;
import com.company.AnnaNicholsU1Capstone.viewmodel.InvoiceViewModel;
import com.company.AnnaNicholsU1Capstone.viewmodel.TShirtViewModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@SpringBootTest
public class InvoiceServiceLayerTest {

    @InjectMocks
    private InvoiceServiceLayer invoiceService;
    private ConsoleServiceLayer consoleService;
    private ConsoleDao consoleDao;
    private InvoiceDao invoiceDao;
    private TShirtDao tShirtDao;
    private GameDao gameDao;
    private InvoiceDaoJdbcTemplateImpl invoiceDaoJdbcTemplate;

    private void setupInvoiceMock(){
        invoiceDao = mock(InvoiceDao.class);
        Invoice invoice = new Invoice();
        invoice.setId(1);
        invoice.setName("John");
        invoice.setStreet("13 street");
        invoice.setCity("Rome");
        invoice.setState("GA");
        invoice.setZipcode("39013");
        invoice.setItemType("Console");
        invoice.setItemId(2);
        invoice.setQuantity(3);
        invoice.setUnitPrice(new BigDecimal("500.00"));
        invoice.setSubtotal(new BigDecimal("1500.00"));
        invoice.setTax(new BigDecimal(".07"));
        invoice.setProcessingFee(new BigDecimal("14.99"));
        invoice.setTotal(new BigDecimal("1619.9900"));

        Invoice invoice2 = new Invoice();
        invoice2.setName("John");
        invoice2.setStreet("13 street");
        invoice2.setCity("Rome");
        invoice2.setState("GA");
        invoice2.setZipcode("39013");
        invoice2.setItemType("Console");
        invoice2.setItemId(2);
        invoice2.setQuantity(3);
        invoice2.setUnitPrice(new BigDecimal("500.00"));
        invoice2.setSubtotal(new BigDecimal("1500.00"));
        invoice2.setTax(new BigDecimal(".07"));
        invoice2.setProcessingFee(new BigDecimal("14.99"));
        invoice2.setTotal(new BigDecimal("1619.9900"));

        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice);

        doReturn(invoice).when(invoiceDao).addInvoice(invoice2);
        doReturn(invoice).when(invoiceDao).getInvoice(1);
        doReturn(invoices).when(invoiceDao).getAllInvoices();

    }

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

    private void setupGameMock(){
        gameDao = mock(GameDao.class);

        Game game = new Game();
        game.setId(3);
        game.setTitle("God of War");
        game.setEsrbRating("M");
        game.setDescription("Action Adventure");
        game.setPrice(new BigDecimal("30.00"));
        game.setStudio("Santa Monica");
        game.setQuantity(new BigDecimal("6"));

        Game game2 = new Game();
        game2.setTitle("God of War");
        game2.setEsrbRating("M");
        game2.setDescription("Action Adventure");
        game2.setPrice(new BigDecimal("30.00"));
        game2.setStudio("Santa Monica");
        game2.setQuantity(new BigDecimal("6"));

        List<Game> games = new ArrayList<>();
        games.add(game);

        doReturn(game).when(gameDao).addGame(game2);
        doReturn(game).when(gameDao).getGame(3);
        doReturn(games).when(gameDao).getAllGames();
    }

    private void setupTshirtMock(){
        tShirtDao = mock(TShirtDao.class);

        TShirt tshirt = new TShirt();
        tshirt.setId(4);
        tshirt.setSize("M");
        tshirt.setColor("Red");
        tshirt.setDescription("Shirt");
        tshirt.setPrice(new BigDecimal("10.00"));
        tshirt.setQuantity(new BigDecimal("2"));

        TShirt tshirt2 = new TShirt();
        tshirt2.setSize("M");
        tshirt2.setColor("Red");
        tshirt2.setDescription("Shirt");
        tshirt2.setPrice(new BigDecimal("10.00"));
        tshirt2.setQuantity(new BigDecimal("2"));

        List<TShirt> tshirts = new ArrayList<>();
        tshirts.add(tshirt);

        doReturn(tshirt).when(tShirtDao).addTShirt(tshirt2);
        doReturn(tshirt).when(tShirtDao).getTShirt(3);
        doReturn(tshirts).when(tShirtDao).getAllTShirts();
    }

    @Before
    public void setUp() throws Exception{
        setupInvoiceMock();
        setupConsoleMock();
        setupGameMock();
        setupTshirtMock();

        invoiceService = new InvoiceServiceLayer( invoiceDaoJdbcTemplate, gameDao, consoleDao, tShirtDao);
    }

    @Test
    public void addInvoice() {

        InvoiceViewModel expected = new InvoiceViewModel();
        expected.setId(0);
        expected.setName("John");
        expected.setStreet("13 street");
        expected.setCity("Rome");
        expected.setState("GA");
        expected.setZipcode("39013");
        expected.setItemType("Console");
        expected.setItemId(2);
        expected.setQuantity(3);

        expected.setUnitPrice(new BigDecimal("500.00"));
        expected.setSubtotal(new BigDecimal("1500.00"));
        expected.setTax(new BigDecimal(".07"));
        expected.setProcessingFee(new BigDecimal("14.99"));
        expected.setTotal(new BigDecimal("1619.9900"));

        Console console = new Console();
        console.setId(2);
        console.setModel("Playstation");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("Intel i7-2880k");
        console.setPrice(new BigDecimal("500.00"));
        console.setQuantity(new BigDecimal(10));
        List<Console> consoles = new ArrayList<>();
        consoles.add(console);
        consoleDao.addConsole(console);

        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setName("John");
        ivm.setStreet("13 street");
        ivm.setCity("Rome");
        ivm.setState("GA");
        ivm.setZipcode("39013");
        ivm.setItemType("Console");
        ivm.setItemId(2);
        ivm.setQuantity(3);

        ivm.setUnitPrice(new BigDecimal("500.00"));
        ivm.setSubtotal(new BigDecimal("1500.00"));
        ivm.setTax(new BigDecimal(".07"));
        ivm.setProcessingFee(new BigDecimal("14.99"));
        ivm.setTotal(new BigDecimal("1619.9900"));
        InvoiceViewModel actual = invoiceService.addInvoiceVm(ivm);

        assertEquals(expected, actual);

    }
}