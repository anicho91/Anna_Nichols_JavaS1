package com.trilogyed.post.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(PostController.class)
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PostDao dao;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void createPost() throws Exception {
        Post post = new Post();
        post.setPostID(1);
        post.setPosterName("bob");
        post.setPost("post");

        String inputJson = mapper.writeValueAsString(post);

        Post post2 = new Post();
        post2.setPostID(1);
        post2.setPosterName("bob");
        post2.setPost("post");
        post2.setPostID(1);

        String outputJson = mapper.writeValueAsString(post2);

        when(dao.addPost(post)).thenReturn(post2);

        mockMvc.perform(post("/posts")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isCreated());

    }

    @Test
    public void getAllPost() throws Exception {
        Post post2 = new Post();
        post2.setPostID(1);
        post2.setPosterName("bob");
        post2.setPost("post");
        post2.setPostID(1);

        String outputJson = mapper.writeValueAsString(post2);

        List<Post> posts = new ArrayList<>();
        posts.add(post2);

        when(dao.getAllPosts()).thenReturn(posts);

        this.mockMvc.perform(get("/posts"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void getPostByPoster() throws Exception {
        Post post2 = new Post();
        post2.setPostID(1);
        post2.setPosterName("bob");
        post2.setPost("post");
        post2.setPostID(1);

        String outputJson = mapper.writeValueAsString(post2);

        List<Post> posts = new ArrayList<>();
        posts.add(post2);

        when(dao.getPostByPoster("bob")).thenReturn(posts);

        this.mockMvc.perform(get("/posts/user/bob"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void getPost() throws Exception {
        Post post2 = new Post();
        post2.setPostID(1);
        post2.setPosterName("bob");
        post2.setPost("post");
        post2.setPostID(1);

        String outputJson = mapper.writeValueAsString(post2);

        when(dao.getPost(1)).thenReturn(post2);

        mockMvc.perform(get("/posts/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void updatePost() throws Exception {

        Post post2 = new Post();
        post2.setPostID(1);
        post2.setPosterName("bob");
        post2.setPost("post");

        String outputJson = mapper.writeValueAsString(post2);

        mockMvc.perform(put("/posts")
                .content(outputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void deletePost() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/posts/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}