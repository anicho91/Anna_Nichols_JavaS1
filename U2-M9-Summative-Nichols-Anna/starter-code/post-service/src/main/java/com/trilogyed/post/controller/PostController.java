package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostDao dao;

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public Post createPost(@RequestBody Post post) {

        return dao.addPost(post);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable int id) {

        return dao.getPost(id);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public List<Post> getAllPosts(){

        return dao.getAllPosts();
    }

    @GetMapping("/posts/poster/{name}")
    public Post getPostByPoster(@PathVariable String name){
        return dao.getPostByPoster(name);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.PUT)
    public void updatePost(@RequestBody Post post) {

        dao.updatePost(post);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable int id) {

        dao.deletePost(id);
    }
}
