package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CommentDaoTest {

    @Autowired
    CommentDao dao;

    @Before
    public void setUp() throws Exception {
        List<Comment> comments = dao.getAllComments();
        comments.stream().forEach(Comment -> dao.deleteComment(Comment.getCommentId()));
    }

    @Test
    public void addComment() {
        Comment comment2 = new Comment();
        comment2.setPostId(1);
        comment2.setCreateDate(LocalDate.of(2019, 03, 03));
        comment2.setCommenterName("bob");
        comment2.setComment("comment");

        comment2 = dao.addComment(comment2);

        Comment comment = dao.getComment(comment2.getCommentId());

        assertEquals(comment.getPostId(), comment2.getPostId());
        assertEquals(comment.getComment(), comment2.getComment());
        assertEquals(comment.getCommenterName(), comment2.getCommenterName());
    }

    @Test
    public void getComment() {
        Comment comment2 = new Comment();
        comment2.setPostId(1);
        comment2.setCreateDate(LocalDate.of(2019, 03, 03));
        comment2.setCommenterName("bob");
        comment2.setComment("comment");

        comment2 = dao.addComment(comment2);

        Comment comment = dao.getComment(comment2.getCommentId());

        assertEquals(comment.getPostId(), comment2.getPostId());
        assertEquals(comment.getComment(), comment2.getComment());
        assertEquals(comment.getCommenterName(), comment2.getCommenterName());
    }

    @Test
    public void getAllComments() {
        Comment comment2 = new Comment();
        comment2.setPostId(1);
        comment2.setCreateDate(LocalDate.of(2019, 03, 03));
        comment2.setCommenterName("bob");
        comment2.setComment("comment");
        dao.addComment(comment2);

        List<Comment> comments = dao.getAllComments();
        assertEquals(comments.size(), 1);
    }

    @Test
    public void getCommentsByPost() {
        Comment comment2 = new Comment();
        comment2.setPostId(1);
        comment2.setCreateDate(LocalDate.of(2019, 03, 03));
        comment2.setCommenterName("bob");
        comment2.setComment("comment");

        dao.addComment(comment2);

        List<Comment> comments = dao.getCommentsByPost(comment2.getPostId());
        assertEquals(1, comment2.getPostId());

    }

    @Test
    public void updateComment() {

        Comment comment2 = new Comment();
        comment2.setPostId(1);
        comment2.setCreateDate(LocalDate.of(2019, 03, 03));
        comment2.setCommenterName("bob");
        comment2.setComment("comment");

        dao.addComment(comment2);

        comment2.setComment("new comment");

        dao.updateComment(comment2);

        Comment comment = dao.getComment(comment2.getCommentId());

        assertEquals(comment.getComment(), comment2.getComment());
    }

    @Test
    public void deleteComment() {

        Comment comment2 = new Comment();
        comment2.setPostId(1);
        comment2.setCreateDate(LocalDate.of(2019, 03, 03));
        comment2.setCommenterName("bob");
        comment2.setComment("comment");

        dao.addComment(comment2);

        dao.deleteComment(comment2.getCommentId());

        Comment comment = dao.getComment(comment2.getCommentId());

        assertNull(comment);
    }
}