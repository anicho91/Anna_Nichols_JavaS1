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
public class AuthorDaoTest {

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
    public void addGetDeleteAuthor() {

        Author author = new Author();
        author.setFirstName("Victor");
        author.setLastName("Hugo");
        author.setStreet("somestreetName");
        author.setCity("Paris");
        author.setState("GA");
        author.setPostalCode("30161");
        author.setPhone("7065555555");
        author.setEmail("email@email.com");
        author = authorDao.addAuthor(author);

        author = authorDao.addAuthor(author);

        Author author1 = authorDao.getAuthor(author.getId());

        assertEquals(author1, author);

        authorDao.deleteAuthor(author.getId());

        author1 = authorDao.getAuthor(author.getId());

        assertNull(author1);

    }

    @Test
    public void getAllAuthors() {

        Author author = new Author();
        author.setFirstName("Victor");
        author.setLastName("Hugo");
        author.setStreet("somestreetName");
        author.setCity("Paris");
        author.setState("GA");
        author.setPostalCode("30161");
        author.setPhone("7065555555");
        author.setEmail("email@email.com");
        author = authorDao.addAuthor(author);

        author = new Author();
        author.setFirstName("H.P.");
        author.setLastName("Lovecraft");
        author.setStreet("somestreetName");
        author.setCity("Boston");
        author.setState("MA");
        author.setPostalCode("30161");
        author.setPhone("7065555555");
        author.setEmail("email@email.com");
        author = authorDao.addAuthor(author);

        List<Author> authors = authorDao.getAllAuthors();
        assertEquals(authors.size(), 2);
    }

    @Test
    public void updateAuthor() {

        Author author = new Author();
        author.setFirstName("Victor");
        author.setLastName("Hugo");
        author.setStreet("somestreetName");
        author.setCity("Paris");
        author.setState("GA");
        author.setPostalCode("30161");
        author.setPhone("7065555555");
        author.setEmail("email@email.com");
        author = authorDao.addAuthor(author);

        author.setPostalCode("34568");

        authorDao.updateAuthor(author);

        Author author1 = authorDao.getAuthor(author.getId());

        assertEquals(author1, author);
    }

}