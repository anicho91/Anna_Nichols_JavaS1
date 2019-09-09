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
public class ConsoleDaoTest {

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
    public void addGetDeleteConsole() {

        Console console = new Console();
        console.setName("Playstation");
        console.setYear("1996");
        consoleDao.addConsole(console);

        Console console1 = consoleDao.getConsole(console.getId());

        assertEquals(console1, console);

        consoleDao.deleteConsole(console.getId());

        console1 = consoleDao.getConsole(console.getId());

        assertNull(console1);
    }

    @Test
    public void getAllConsoles() {
        Console console = new Console();
        console.setName("Playstation");
        console.setYear("1996");
        consoleDao.addConsole(console);

        Console console2 = new Console();
        console2.setName("Xbox");
        console2.setYear("2002");
        consoleDao.addConsole(console2);

        List<Console> consoleList = consoleDao.getAllConsoles();

        assertEquals(consoleList.size(), 2);
    }

    @Test
    public void updateConsole() {
        Console console = new Console();
        console.setName("Playstation");
        console.setYear("1996");
        consoleDao.addConsole(console);

        console.setYear("1994");
        consoleDao.updateConsole(console);

        Console console1 = consoleDao.getConsole(console.getId());

        assertEquals(console1, console);

    }

}