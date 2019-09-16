package com.company.AnnaNicholsU1M5Summative.dao;

import com.company.AnnaNicholsU1M5Summative.dto.Author;
import com.company.AnnaNicholsU1M5Summative.dto.Book;
import com.company.AnnaNicholsU1M5Summative.dto.Publisher;
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
    AuthorDao authorDao;
    @Autowired
    PublisherDao publisherDao;
    @Autowired
    BookDao bookDao;

    @Before
    public void setUp() throws Exception {
        List<Book> books = bookDao.getAllBooks();
        books.stream().forEach(Book -> bookDao.deleteBook(Book.getId()));

        List<Author> authors = authorDao.getAllAuthors();
        authors.stream().forEach(Author -> authorDao.deleteAuthor(Author.getId()));

        List<Publisher> publishers = publisherDao.getAllPublishers();
        publishers.stream().forEach(Publisher -> publisherDao.deletePublisher(Publisher.getId()));
    }

    @Test
    public void addGetDeletePublisher() {

        Publisher publisher = new Publisher();
        publisher.setName("PublisherCo");
        publisher.setStreet("publisherstreet");
        publisher.setCity("Cairo");
        publisher.setState("GA");
        publisher.setPostalCode("25752");
        publisher.setPhone("7708889995");
        publisher.setEmail("email2@pub.com");
        publisher = publisherDao.addPublisher(publisher);

        Publisher publisher1 = publisherDao.getPublisher(publisher.getId());

        assertEquals(publisher1, publisher);

        publisherDao.deletePublisher(publisher.getId());

        publisher1 = publisherDao.getPublisher(publisher.getId());

        assertNull(publisher1);
    }

    @Test
    public void getAllPublishers() {
        Publisher publisher = new Publisher();
        publisher.setName("PublisherCo");
        publisher.setStreet("publisherstreet");
        publisher.setCity("Cairo");
        publisher.setState("GA");
        publisher.setPostalCode("25752");
        publisher.setPhone("7708889995");
        publisher.setEmail("email2@pub.com");
        publisher = publisherDao.addPublisher(publisher);

        publisher = new Publisher();
        publisher.setName("Bloomberg");
        publisher.setStreet("New york street");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("25752");
        publisher.setPhone("7708889995");
        publisher.setEmail("email2@pub.com");
        publisher = publisherDao.addPublisher(publisher);

        List<Publisher> publishers = publisherDao.getAllPublishers();
        assertEquals(publishers.size(), 2);
    }

    @Test
    public void updatePublisher() {

        Publisher publisher = new Publisher();
        publisher.setName("PublisherCo");
        publisher.setStreet("publisherstreet");
        publisher.setCity("Cairo");
        publisher.setState("GA");
        publisher.setPostalCode("25752");
        publisher.setPhone("7708889995");
        publisher.setEmail("email2@pub.com");
        publisher = publisherDao.addPublisher(publisher);

        publisher.setCity("Atlanta");

        publisherDao.updatePublisher(publisher);

        Publisher publisher1 = publisherDao.getPublisher(publisher.getId());

        assertEquals(publisher1, publisher);

    }

}