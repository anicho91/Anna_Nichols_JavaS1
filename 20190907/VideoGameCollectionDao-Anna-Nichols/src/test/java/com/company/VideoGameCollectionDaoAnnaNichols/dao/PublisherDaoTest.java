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
public class PublisherDaoTest {

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
    public void addGetDeletePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Santa Monica Studios");
        publisher.setWebsite("www.website.com");
        publisherDao.addPublisher(publisher);


        Publisher publisher1 = publisherDao.getPublisher(publisher.getId());

        assertEquals(publisher1, publisher);

        publisherDao.deletePublisher(publisher.getId());

        publisher1 = publisherDao.getPublisher(publisher.getId());

        assertNull(publisher1);

    }

    @Test
    public void getAllPublishers() {
        Publisher publisher = new Publisher();
        publisher.setName("Santa Monica Studios");
        publisher.setWebsite("www.website.com");
        publisherDao.addPublisher(publisher);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Naughty Dog");
        publisher2.setWebsite("www.website2.com");
        publisherDao.addPublisher(publisher2);

        List<Publisher> publisherList = publisherDao.getAllPublishers();

        assertEquals(publisherList.size(), 2);

    }

    @Test
    public void updatePublisher() {
        Publisher publisher2 = new Publisher();
        publisher2.setName("Naughty Dog");
        publisher2.setWebsite("www.website2.com");
        publisherDao.addPublisher(publisher2);

        publisher2.setWebsite("www.newwebsite.com");
        publisherDao.updatePublisher(publisher2);

        Publisher publisher1 = publisherDao.getPublisher(publisher2.getId());

        assertEquals(publisher1, publisher2);
    }
}