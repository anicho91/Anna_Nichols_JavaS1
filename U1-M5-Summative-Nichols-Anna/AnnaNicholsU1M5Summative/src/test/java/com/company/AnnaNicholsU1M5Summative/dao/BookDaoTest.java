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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoTest {

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
    public void addGetDeleteBook() {

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

        Publisher publisher = new Publisher();
        publisher.setName("PublisherCo");
        publisher.setStreet("publisherstreet");
        publisher.setCity("Cairo");
        publisher.setState("GA");
        publisher.setPostalCode("25752");
        publisher.setPhone("7708889995");
        publisher.setEmail("email2@pub.com");
        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book();
        book.setIsbn("48-522-582");
        book.setPublishDate(LocalDate.of(2015,05,03));
        book.setAuthorId(author.getId());
        book.setTitle("Les Miserables");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("14.00"));
        book = bookDao.addBook(book);

        Book book1 = bookDao.getBook(book.getId());

        assertEquals(book1, book);

        bookDao.deleteBook(book.getId());

        book1 = bookDao.getBook(book.getId());

        assertNull(book1);
    }

    @Test
    public void getAllBooks() {

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

        Publisher publisher = new Publisher();
        publisher.setName("PublisherCo");
        publisher.setStreet("publisherstreet");
        publisher.setCity("Cairo");
        publisher.setState("GA");
        publisher.setPostalCode("25752");
        publisher.setPhone("7708889995");
        publisher.setEmail("email2@pub.com");
        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book();
        book.setIsbn("48-522-582");
        book.setPublishDate(LocalDate.of(2015,05,03));
        book.setAuthorId(author.getId());
        book.setTitle("Les Miserables");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("14.00"));
        book = bookDao.addBook(book);

        book = new Book();
        book.setIsbn("48-522-582");
        book.setPublishDate(LocalDate.of(1991,05,03));
        book.setAuthorId(author.getId());
        book.setTitle("Hunchback of Notre Dame");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("24.00"));
        book = bookDao.addBook(book);

        List<Book> books = bookDao.getAllBooks();

        assertEquals(books.size(), 2);

    }

    @Test
    public void getBookByAuthor() {

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

        Author author2 = new Author();
        author2.setFirstName("H.P.");
        author2.setLastName("Lovecraft");
        author2.setStreet("somestreetName");
        author2.setCity("Boston");
        author2.setState("MA");
        author2.setPostalCode("30161");
        author2.setPhone("7065555555");
        author2.setEmail("email@email.com");
        author2 = authorDao.addAuthor(author2);

        Publisher publisher = new Publisher();
        publisher.setName("PublisherCo");
        publisher.setStreet("publisherstreet");
        publisher.setCity("Cairo");
        publisher.setState("GA");
        publisher.setPostalCode("25752");
        publisher.setPhone("7708889995");
        publisher.setEmail("email2@pub.com");
        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book();
        book.setIsbn("48-522-582");
        book.setPublishDate(LocalDate.of(2015,05,03));
        book.setAuthorId(author.getId());
        book.setTitle("Les Miserables");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("14.00"));
        book = bookDao.addBook(book);

        book = new Book();
        book.setIsbn("48-522-532");
        book.setPublishDate(LocalDate.of(1952,04,12));
        book.setAuthorId(author2.getId());
        book.setTitle("The Dunwich Horror");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("18.00"));
        book = bookDao.addBook(book);

        List<Book> books = bookDao.getBookByAuthor(author2.getId());
        assertEquals(1, books.size());

        List<Book> books2 = bookDao.getBookByAuthor(author.getId());
        assertEquals(1, books2.size());
    }

    @Test
    public void updateBook() {

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

        Publisher publisher = new Publisher();
        publisher.setName("PublisherCo");
        publisher.setStreet("publisherstreet");
        publisher.setCity("Cairo");
        publisher.setState("GA");
        publisher.setPostalCode("25752");
        publisher.setPhone("7708889995");
        publisher.setEmail("email2@pub.com");
        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book();
        book.setIsbn("48-522-582");
        book.setPublishDate(LocalDate.of(2015,05,03));
        book.setAuthorId(author.getId());
        book.setTitle("Les Miserables");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("14.00"));
        book = bookDao.addBook(book);


        book.setPrice(new BigDecimal("24.00"));
        bookDao.updateBook(book);

        Book book1 = bookDao.getBook(book.getId());

        assertEquals(book1, book);
    }

}