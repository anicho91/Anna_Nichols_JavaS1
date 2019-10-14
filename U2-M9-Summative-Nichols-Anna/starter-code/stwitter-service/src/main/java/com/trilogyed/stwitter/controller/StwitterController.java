package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.viewmodel.PostViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/posts")
@CacheConfig(cacheNames = {"posts"})
public class StwitterController {

    @Autowired
    ServiceLayer service;

    @CachePut(key = "#result.getPostId()")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PostViewModel createPost(@Valid @RequestBody PostViewModel post ){

        return service.addPostVm(post);
    }

    @Cacheable
    @GetMapping("/{id}")
    public PostViewModel getPostById(@Valid @PathVariable int id ){

        return service.getPostVm(id);
    }

    @GetMapping("/user/{poster_name}")
    public PostViewModel getPostByPosters(@Valid @PathVariable String poster_name){

        return service.getPostByPosters(poster_name);
    }
}
