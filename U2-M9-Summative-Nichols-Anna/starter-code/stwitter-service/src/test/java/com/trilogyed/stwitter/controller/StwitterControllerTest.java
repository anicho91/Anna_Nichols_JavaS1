package com.trilogyed.stwitter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.util.feign.model.Comment;
import com.trilogyed.stwitter.viewmodel.PostViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(StwitterController.class)
public class StwitterControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ServiceLayer service;

    @MockBean
    RabbitTemplate rabbitTemplate;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void createPost() throws Exception {

        PostViewModel pvm = new PostViewModel();
        pvm.setPosterName("Bob");
        pvm.setPostDate(LocalDate.of(2019, 03, 03));
        pvm.setPostContent("Post content");
        Comment comment = new Comment();
        comment.setCommentContent("comment");

        List<Comment> comments = new ArrayList<>();
        comments.add(comment);

        pvm.setComments(comments);

        String inputJson = mapper.writeValueAsString(pvm);

        PostViewModel pvm2 = new PostViewModel();
        pvm2.setPosterName("Bob");
        pvm2.setPostContent("Post content");
        pvm2.setComments(comments);
        pvm2.setPostId(1);

        String outputJson = mapper.writeValueAsString(pvm2);

        when(service.addPostVm(pvm)).thenReturn(pvm2);

        mockMvc.perform(post("/posts")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                        .andDo(print())
                        .andExpect(status().isCreated())
                        .andExpect(content().json(outputJson));

    }

    @Test
    public void getPostById() throws Exception {
        PostViewModel pvm = new PostViewModel();
        pvm.setPosterName("Bob");
        pvm.setPostContent("Post content");
        Comment comment = new Comment();
        comment.setCommentContent("comment");

        List<Comment> comments = new ArrayList<>();
        comments.add(comment);

        pvm.setComments(comments);
        pvm.setPostId(1);

        String outputJson = mapper.writeValueAsString(pvm);

        when(service.getPostVm(1)).thenReturn(pvm);

        mockMvc.perform(get("/posts/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void getPostByPosters() throws Exception {

        PostViewModel pvm = new PostViewModel();
        pvm.setPosterName("Bob");
        pvm.setPostContent("Post content");
        Comment comment = new Comment();
        comment.setCommentContent("comment");

        List<Comment> comments = new ArrayList<>();
        comments.add(comment);

        pvm.setComments(comments);
        pvm.setPostId(1);

        String outputJson = mapper.writeValueAsString(pvm);

        when(service.getPostByPosters("Bob")).thenReturn(pvm);

        mockMvc.perform(get("/posts/user/Bob"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }
}