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
public class TypeDaoTest {

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
    public void addGetDeleteType() {
        Type type = new Type();
        type.setName("Action Adventure");
        type.setDescription("action and adventure");
        typeDao.addType(type);

        Type type1 = typeDao.getType(type.getId());

        assertEquals(type1, type);

        typeDao.deleteType(type.getId());

        type1 = typeDao.getType(type.getId());

        assertNull(type1);
    }

    @Test
    public void getAllTypes() {
        Type type = new Type();
        type.setName("Action Adventure");
        type.setDescription("action and adventure");
        typeDao.addType(type);

        Type type2 = new Type();
        type2.setName("RPG");
        type2.setDescription("roleplaying game");
        typeDao.addType(type2);

        List<Type> types = typeDao.getAllTypes();

        assertEquals(types.size(), 2);

    }

    @Test
    public void updateType() {
        Type type = new Type();
        type.setName("Action Adventure");
        type.setDescription("action and adventure");
        typeDao.addType(type);

        type.setDescription("Combines combat with Adventure elements");
        typeDao.updateType(type);

        Type type1 = typeDao.getType(type.getId());

        assertEquals(type1, type);

    }

}