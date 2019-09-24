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
public class GameDaoTest {

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
    public void addGetDeleteGame() {
        Game game = new Game();
        game.setTitle("God of War");
        game.setEsrbRating("M");
        game.setDescription("Action Adventure");
        game.setPrice(new BigDecimal( "30.00"));
        game.setStudio("Santa Monica");
        game.setQuantity(new BigDecimal("6"));
        game = gameDao.addGame(game);

        Game game1 = gameDao.getGame(game.getId());

        assertEquals(game1, game);

        gameDao.deleteGame(game.getId());

        game1 = gameDao.getGame(game.getId());

        assertNull(game1);
    }

    @Test
    public void getAllGames() {
        Game game = new Game();
        game.setTitle("God of War");
        game.setEsrbRating("M");
        game.setDescription("Action Adventure");
        game.setPrice(new BigDecimal("30.00"));
        game.setStudio("Santa Monica");
        game.setQuantity(new BigDecimal("6"));
        game = gameDao.addGame(game);

        game = new Game();
        game.setTitle("Quest for Glory");
        game.setEsrbRating("T");
        game.setDescription("Point and Click Action Adventure");
        game.setPrice(new BigDecimal("10.00"));
        game.setStudio("Sierra");
        game.setQuantity(new BigDecimal("16"));
        game = gameDao.addGame(game);

        List<Game> games = gameDao.getAllGames();
        assertEquals(games.size(), 2);

    }

    @Test
    public void updateGame() {
        Game game = new Game();
        game.setTitle("God of War");
        game.setEsrbRating("M");
        game.setDescription("Action Adventure");
        game.setPrice(new BigDecimal("30.00"));
        game.setStudio("Santa Monica");
        game.setQuantity(new BigDecimal("6"));
        game = gameDao.addGame(game);

        game.setQuantity(new BigDecimal("10"));
        gameDao.updateGame(game);

        Game game1 = gameDao.getGame(game.getId());

        assertEquals(game1, game);
    }

    @Test
    public void getByStudio() {

        Game game = new Game();
        game.setTitle("God of War");
        game.setEsrbRating("M");
        game.setDescription("Action Adventure");
        game.setPrice(new BigDecimal("30.00"));
        game.setStudio("Santa Monica");
        game.setQuantity(new BigDecimal("6"));
        game = gameDao.addGame(game);

        Game game2 = new Game();
        game2.setTitle("Quest for Glory");
        game2.setEsrbRating("T");
        game2.setDescription("Point and Click Action Adventure");
        game2.setPrice(new BigDecimal("10.00"));
        game2.setStudio("Sierra");
        game2.setQuantity(new BigDecimal("16"));
        game2 = gameDao.addGame(game2);

        List<Game> games = gameDao.getByStudio(game2.getStudio());
        assertEquals("Sierra", game2.getStudio());
    }

    @Test
    public void getByEsrbRating() {
        Game game = new Game();
        game.setTitle("God of War");
        game.setEsrbRating("M");
        game.setDescription("Action Adventure");
        game.setPrice(new BigDecimal("30.00"));
        game.setStudio("Santa Monica");
        game.setQuantity(new BigDecimal("6"));
        game = gameDao.addGame(game);

        Game game2 = new Game();
        game2.setTitle("Quest for Glory");
        game2.setEsrbRating("T");
        game2.setDescription("Point and Click Action Adventure");
        game2.setPrice(new BigDecimal("10.00"));
        game2.setStudio("Sierra");
        game2.setQuantity(new BigDecimal("16"));
        game2 = gameDao.addGame(game2);

        List<Game> games = gameDao.getByEsrbRating(game2.getEsrbRating());
        assertEquals("T", game2.getEsrbRating());

    }

    @Test
    public void getByTitle() {
        Game game = new Game();
        game.setTitle("God of War");
        game.setEsrbRating("M");
        game.setDescription("Action Adventure");
        game.setPrice(new BigDecimal("30.00"));
        game.setStudio("Santa Monica");
        game.setQuantity(new BigDecimal("6"));
        game = gameDao.addGame(game);

        Game game2 = new Game();
        game2.setTitle("Quest for Glory");
        game2.setEsrbRating("T");
        game2.setDescription("Point and Click Action Adventure");
        game2.setPrice(new BigDecimal("10.00"));
        game2.setStudio("Sierra");
        game2.setQuantity(new BigDecimal("16"));
        game2 = gameDao.addGame(game2);

        List<Game> games = gameDao.getByTitle(game.getTitle());
        assertEquals("God of War", game.getTitle());

    }
}