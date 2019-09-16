package com.company.AnnaNicholsU1M5Summative.controllers;

import com.company.AnnaNicholsU1M5Summative.dao.BookDao;
import com.company.AnnaNicholsU1M5Summative.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookDao bookDao;
    
    private List<Book> bookList = new ArrayList<>();

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Book postBook(@RequestBody @Valid Book book) {
        return bookDao.addBook(book);

    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Book> getBooks() {

        return bookDao.getAllBooks();
    }

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Book getOneBook(@PathVariable int bookId) {
        return bookDao.getBook(bookId);
    }

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteBook(@PathVariable int bookId) {

        bookDao.deleteBook(bookId);
    }

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateBook(@PathVariable int bookId, @RequestBody Book book) {

        book = bookDao.getBook(bookId);

        bookDao.updateBook(book);
    }

}
