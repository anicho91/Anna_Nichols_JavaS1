package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.viewmodel.PostViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CacheConfig(cacheNames = {"posts"})
public class StwitterController {

    @Autowired
    ServiceLayer service;

    @CachePut(key = "#result.getPostId()")
    @PostMapping
    public PostViewModel createPost(@RequestBody PostViewModel post){

        return service.addPostVm(post);
    }

    @Cacheable
    @GetMapping("/{id}")
    public PostViewModel getPostById(@PathVariable int postId){

        return service.getPostVm(postId);
    }

    @GetMapping("/user/{poster_name}")
    public PostViewModel getPostByPosters(@PathVariable String poster_name){

        return service.getPostByPosters(poster_name);
    }
}
