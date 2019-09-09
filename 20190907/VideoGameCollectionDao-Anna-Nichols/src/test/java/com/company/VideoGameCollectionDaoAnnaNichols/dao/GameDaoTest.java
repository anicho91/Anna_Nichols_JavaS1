package com.company.VideoGameCollectionDaoAnnaNichols.dao;

import com.company.VideoGameCollectionDaoAnnaNichols.model.Console;
import com.company.VideoGameCollectionDaoAnnaNichols.model.Game;
import com.company.VideoGameCollectionDaoAnnaNichols.model.Publisher;
import com.company.VideoGameCollectionDaoAnnaNichols.model.Type;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    PublisherDao publisherDao;
    @Autowired
    TypeDao typeDao;


    @Before
    public void setUp() throws Exception {

        List<Game> gameList = gameDao.getAllGames();
        gameList.stream().forEach(Game -> gameDao.deleteGame(Game.getId()));

        List<Console> consoleList = consoleDao.getAllConsoles();
        consoleList.stream().forEach(Console -> consoleDao.deleteConsole(Console.getId()));

        List<Type> typeList = typeDao.getAllTypes();
        typeList.stream().forEach(Type -> typeDao.deleteType(Type.getId()));

        List<Publisher> publisherList = publisherDao.getAllPublishers();
        publisherList.stream().forEach(Publisher -> publisherDao.deletePublisher(Publisher.getId()));
    }

    @Test
    public void addGetDeleteGame() {
        Console console = new Console();
        console.setName("Playstation");
        console.setYear("1996");
        consoleDao.addConsole(console);

        Publisher publisher = new Publisher();
        publisher.setName("Santa Monica Studios");
        publisher.setWebsite("www.website.com");
        publisherDao.addPublisher(publisher);

        Type type = new Type();
        type.setName("Action Adventure");
        type.setDescription("action and adventure");
        typeDao.addType(type);

        Game game = new Game();
        game.setConsoleId(console.getId());
        game.setPublisherId(publisher.getId());
        game.setTypeId(type.getId());
        gameDao.addGame(game);

        Game game1 = gameDao.getGame(game.getId());

        assertEquals(game1, game);

        gameDao.deleteGame(game.getId());

        game1 = gameDao.getGame(game.getId());

        assertNull(game1);

    }

    @Test
    public void getAllGames() {
        Console console = new Console();
        console.setName("Playstation");
        console.setYear("1996");
        consoleDao.addConsole(console);

        Publisher publisher = new Publisher();
        publisher.setName("Santa Monica Studios");
        publisher.setWebsite("www.website.com");
        publisherDao.addPublisher(publisher);

        Type type = new Type();
        type.setName("Action Adventure");
        type.setDescription("action and adventure");
        typeDao.addType(type);

        Game game = new Game();
        game.setConsoleId(console.getId());
        game.setPublisherId(publisher.getId());
        game.setTypeId(type.getId());
        gameDao.addGame(game);

        Console console2 = new Console();
        console2.setName("Xbox");
        console2.setYear("2002");
        consoleDao.addConsole(console2);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Santa Monica Studios");
        publisher2.setWebsite("www.website2.com");
        publisherDao.addPublisher(publisher2);

        Type type2 = new Type();
        type2.setName("RPG");
        type2.setDescription("roleplaying");
        typeDao.addType(type2);

        game = new Game();
        game.setConsoleId(console2.getId());
        game.setPublisherId(publisher2.getId());
        game.setTypeId(type2.getId());
        gameDao.addGame(game);

        List<Game> gameList = gameDao.getAllGames();

        assertEquals(gameList.size(), 2);

    }

    @Test
    public void updateGame() {

        Console console = new Console();
        console.setName("Playstation");
        console.setYear("1996");
        consoleDao.addConsole(console);

        Console console2 = new Console();
        console2.setName("Xbox");
        console2.setYear("2002");
        consoleDao.addConsole(console2);

        Publisher publisher = new Publisher();
        publisher.setName("Santa Monica Studios");
        publisher.setWebsite("www.website.com");
        publisherDao.addPublisher(publisher);

        Type type = new Type();
        type.setName("Action Adventure");
        type.setDescription("action and adventure");
        typeDao.addType(type);

        Game game = new Game();
        game.setConsoleId(console.getId());
        game.setPublisherId(publisher.getId());
        game.setTypeId(type.getId());
        gameDao.addGame(game);

        game.setConsoleId(console2.getId());
        gameDao.updateGame(game);

        Game game1 = gameDao.getGame(game.getId());
        assertEquals(game1, game);

    }

}