package com.company.AnnaNicholsU1Capstone.service;

import com.company.AnnaNicholsU1Capstone.dao.*;
import com.company.AnnaNicholsU1Capstone.viewmodel.ConsoleViewModel;
import com.company.AnnaNicholsU1Capstone.viewmodel.GameViewModel;
import com.company.AnnaNicholsU1Capstone.viewmodel.InvoiceViewModel;
import com.company.AnnaNicholsU1Capstone.viewmodel.TShirtViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class InvoiceServiceLayerTest {

    private InvoiceServiceLayer invoiceService;
    private ConsoleServiceLayer consoleService;
    private ConsoleViewDao consoleViewDao;
    private InvoiceViewDao invoiceViewDao;
    private TShirtViewDao tShirtViewDao;
    private GameViewDao gameViewDao;
    private InvoiceDaoJdbcTemplateImpl invoiceDaoJdbcTemplate;

    private void setupInvoiceMock(){
        invoiceViewDao = mock(InvoiceViewDao.class);
        InvoiceViewModel invoice = new InvoiceViewModel();
        invoice.setId(1);
        invoice.setName("John");
        invoice.setStreet("13 street");
        invoice.setCity("Rome");
        invoice.setState("GA");
        invoice.setZipcode("39013");
        invoice.setItemType("Console");
        invoice.setItemId(2);
        invoice.setQuantity(3);
        invoice.setUnitPrice(new BigDecimal("2.00"));
        invoice.setSubtotal(new BigDecimal("6.00"));
        invoice.setTax(new BigDecimal(".04"));
        invoice.setProcessingFee(new BigDecimal("1.99"));
        invoice.setTotal(new BigDecimal("15.00"));

        InvoiceViewModel invoice2 = new InvoiceViewModel();
        invoice2.setName("John");
        invoice2.setStreet("13 street");
        invoice2.setCity("Rome");
        invoice2.setState("GA");
        invoice2.setZipcode("39013");
        invoice2.setItemType("Console");
        invoice2.setItemId(2);
        invoice2.setQuantity(3);
        invoice2.setUnitPrice(new BigDecimal("2.00"));
        invoice2.setSubtotal(new BigDecimal("6.00"));
        invoice2.setTax(new BigDecimal(".04"));
        invoice2.setProcessingFee(new BigDecimal("1.99"));
        invoice2.setTotal(new BigDecimal("15.00"));

        List<InvoiceViewModel> invoices = new ArrayList<>();
        invoices.add(invoice);

        doReturn(invoice).when(invoiceViewDao).addInvoiceVm(invoice2);
        doReturn(invoice).when(invoiceViewDao).getInvoiceVm(1);
        doReturn(invoices).when(invoiceViewDao).getAllInvoicesVm();

    }

    private void setupConsoleMock(){
        consoleViewDao = mock(ConsoleViewDao.class);

        ConsoleViewModel console = new ConsoleViewModel();
        console.setId(2);
        console.setModel("Playstation");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("Intel i7-2880k");
        console.setPrice(new BigDecimal("500.00"));
        console.setQuantity(new BigDecimal(10));

        ConsoleViewModel console2 = new ConsoleViewModel();
        console2.setModel("Playstation");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("2TB");
        console2.setProcessor("Intel i7-2880k");
        console2.setPrice(new BigDecimal("500.00"));
        console2.setQuantity(new BigDecimal(10));

        List<ConsoleViewModel> consoles = new ArrayList<>();
        consoles.add(console);

        doReturn(console).when(consoleViewDao).addConsoleVm(console2);
        doReturn(console).when(consoleViewDao).getConsoleVm(2);
        doReturn(consoles).when(consoleViewDao).getAllConsolesVm();
    }

    private void setupGameMock(){
        gameViewDao = mock(GameViewDao.class);

        GameViewModel game = new GameViewModel();
        game.setId(3);
        game.setTitle("God of War");
        game.setEsrbRating("M");
        game.setDescription("Action Adventure");
        game.setPrice(new BigDecimal("30.00"));
        game.setStudio("Santa Monica");
        game.setQuantity(new BigDecimal("6"));

        GameViewModel game2 = new GameViewModel();
        game2.setTitle("God of War");
        game2.setEsrbRating("M");
        game2.setDescription("Action Adventure");
        game2.setPrice(new BigDecimal("30.00"));
        game2.setStudio("Santa Monica");
        game2.setQuantity(new BigDecimal("6"));

        List<GameViewModel> games = new ArrayList<>();
        games.add(game);

        doReturn(game).when(gameViewDao).addGameVm(game2);
        doReturn(game).when(gameViewDao).getGameVm(3);
        doReturn(games).when(gameViewDao).getAllGamesVm();
    }

    private void setupTshirtMock(){
        tShirtViewDao = mock(TShirtViewDao.class);

        TShirtViewModel tshirt = new TShirtViewModel();
        tshirt.setId(4);
        tshirt.setSize("M");
        tshirt.setColor("Red");
        tshirt.setDescription("Shirt");
        tshirt.setPrice(new BigDecimal("10.00"));
        tshirt.setQuantity(new BigDecimal("2"));

        TShirtViewModel tshirt2 = new TShirtViewModel();
        tshirt2.setSize("M");
        tshirt2.setColor("Red");
        tshirt2.setDescription("Shirt");
        tshirt2.setPrice(new BigDecimal("10.00"));
        tshirt2.setQuantity(new BigDecimal("2"));

        List<TShirtViewModel> tshirts = new ArrayList<>();
        tshirts.add(tshirt);

        doReturn(tshirt).when(tShirtViewDao).addTShirtVm(tshirt2);
        doReturn(tshirt).when(tShirtViewDao).getTShirtVm(3);
        doReturn(tshirts).when(tShirtViewDao).getAllTShirtsVm();
    }

    @Before
    public void setUp() throws Exception{
        setupInvoiceMock();
        setupConsoleMock();
        setupGameMock();
        setupTshirtMock();

        invoiceService = new InvoiceServiceLayer( invoiceDaoJdbcTemplate, gameViewDao, consoleViewDao, tShirtViewDao);
    }

    @Test
    public void addInvoiceVm() {

//        console = consoleService.addConsoleVm(console);

        ConsoleViewModel console = new ConsoleViewModel();
        console.setId(2);
        console.setModel("Playstation");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("Intel i7-2880k");
        console.setPrice(new BigDecimal("500.00"));
        console.setQuantity(new BigDecimal(10));
        List<ConsoleViewModel> consoles = new ArrayList<>();
        consoles.add(console);

        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setId(1);
        ivm.setName("John");
        ivm.setStreet("13 street");
        ivm.setCity("Rome");
        ivm.setState("GA");
        ivm.setZipcode("39013");
        ivm.setItemType("Console");
        ivm.setItemId(2);
        ivm.setQuantity(3);

        ivm.setUnitPrice(new BigDecimal("2.00"));
        ivm.setSubtotal(new BigDecimal("6.00"));
        ivm.setTax(new BigDecimal(".04"));
        ivm.setProcessingFee(new BigDecimal("1.99"));
        ivm.setTotal(new BigDecimal("15.00"));
        ivm = invoiceService.addInvoiceVm(ivm);

        InvoiceViewModel fromService = invoiceService.getInvoiceVm(ivm.getId());
        assertEquals(ivm, fromService);

        List<InvoiceViewModel> invoiceViewModels = invoiceService.getAllInvoicesVm();
        assertEquals(1, invoiceViewModels.size());
        assertEquals(ivm, invoiceViewModels.get(0));

    }

    @Test
    public void getAllInvoicesVm() {

    }

    @Test
    public void deleteInvoiceVm() {
    }
}