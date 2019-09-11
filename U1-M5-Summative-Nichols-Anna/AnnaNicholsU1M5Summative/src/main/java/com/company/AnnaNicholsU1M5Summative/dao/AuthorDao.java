package com.company.AnnaNicholsU1M5Summative.dao;

import com.company.AnnaNicholsU1M5Summative.dto.Author;

import java.util.List;

public interface AuthorDao {
    Author addAuthor(Author author);

    Author getAuthor(int id);

    List<Author> getAllAuthors();

    void updateAuthor(Author author);

    void deleteAuthor(int id);
}
