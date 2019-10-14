package com.trilogyed.comment.controller;

import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.dao.CommentDaoJdbcTemplate;
import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentDao dao;

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComment(@Valid @RequestBody Comment comment) {

        return dao.addComment(comment);
    }

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public List<Comment> getAllComment(){

        return dao.getAllComments();
    }

    @RequestMapping(value = "/comments/posts/{postid}", method = RequestMethod.GET)
    public List<Comment> getCommentsByPost(@Valid @PathVariable int postid){
        return dao.getCommentsByPost(postid);
    }

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    public Comment getComment(@PathVariable int id) {

        return dao.getComment(id);
    }

    @RequestMapping(value = "/comments", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateComment(@RequestBody Comment comment) {

        dao.updateComment(comment);

    }

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteComment(@Valid @PathVariable int id) {

        dao.deleteComment(id);

    }
    
}