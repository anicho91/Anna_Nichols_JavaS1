package com.company.AnnaNicholsU1M5Summative.controllers;

import com.company.AnnaNicholsU1M5Summative.dao.AuthorDao;
import com.company.AnnaNicholsU1M5Summative.dto.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    AuthorDao authorDao;

    private List<Author> authorList = new ArrayList<>();

    @RequestMapping(value = "/author", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Author postAuthor(@RequestBody @Valid Author author) {
        return authorDao.addAuthor(author);

    }

    @RequestMapping(value = "/author", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Author> getAuthors() {

        return authorDao.getAllAuthors();
    }

    @RequestMapping(value = "/author/{authorId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Author getOneAuthor(@PathVariable int authorId) {
        return authorDao.getAuthor(authorId);
    }

    @RequestMapping(value = "/author/{authorId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteAuthor(@PathVariable int authorId) {

        authorDao.deleteAuthor(authorId);
    }

    @RequestMapping(value = "/author/{authorId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateAuthor(@PathVariable int authorId, @RequestBody Author author) {

        authorDao.updateAuthor(author);
    }
    
}
