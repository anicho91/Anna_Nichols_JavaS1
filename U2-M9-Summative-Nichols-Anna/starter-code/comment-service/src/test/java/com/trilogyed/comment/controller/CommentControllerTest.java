package com.trilogyed.comment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CommentController.class)
public class CommentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CommentDao dao;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void createComment() throws Exception {
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCommenterName("bob");
        comment.setComment("comment");

        String inputJson = mapper.writeValueAsString(comment);

        Comment comment2 = new Comment();
        comment2.setPostId(1);
        comment2.setCommenterName("bob");
        comment2.setComment("comment");
        comment2.setCommentId(1);

        String outputJson = mapper.writeValueAsString(comment2);

        when(dao.addComment(comment)).thenReturn(comment2);

        mockMvc.perform(post("/comments")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isCreated());

    }

    @Test
    public void getAllComment() throws Exception {
        Comment comment2 = new Comment();
        comment2.setPostId(1);
        comment2.setCommenterName("bob");
        comment2.setComment("comment");
        comment2.setCommentId(1);

        String outputJson = mapper.writeValueAsString(comment2);

        List<Comment> comments = new ArrayList<>();
        comments.add(comment2);

        when(dao.getAllComments()).thenReturn(comments);

        this.mockMvc.perform(get("/comments"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void getCommentsByPost() throws Exception {
        Comment comment2 = new Comment();
        comment2.setPostId(1);
        comment2.setCommenterName("bob");
        comment2.setComment("comment");
        comment2.setCommentId(1);

        String outputJson = mapper.writeValueAsString(comment2);

        List<Comment> comments = new ArrayList<>();
        comments.add(comment2);

        when(dao.getCommentsByPost(1)).thenReturn(comments);

        this.mockMvc.perform(get("/comments/posts/1"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void getComment() throws Exception {
        Comment comment2 = new Comment();
        comment2.setPostId(1);
        comment2.setCommenterName("bob");
        comment2.setComment("comment");
        comment2.setCommentId(1);

        String outputJson = mapper.writeValueAsString(comment2);

        when(dao.getComment(1)).thenReturn(comment2);

        mockMvc.perform(get("/comments/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void updateComment() throws Exception {

        Comment comment2 = new Comment();
        comment2.setPostId(1);
        comment2.setCommenterName("bob");
        comment2.setComment("comment");
        comment2.setCommentId(1);

        String outputJson = mapper.writeValueAsString(comment2);

        mockMvc.perform(put("/comments")
                .content(outputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void deleteComment() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/comments/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}