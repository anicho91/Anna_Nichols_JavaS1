package com.company.AnnaNicholsU1M5Summative.dao;

import com.company.AnnaNicholsU1M5Summative.dto.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookDao {
    Book addBook(Book book);

    Book getBook(int id);

    List<Book> getAllBooks();

    List<Book> getBookByAuthor(int authorId);

    void updateBook(Book book);

    void deleteBook(int id);

}
