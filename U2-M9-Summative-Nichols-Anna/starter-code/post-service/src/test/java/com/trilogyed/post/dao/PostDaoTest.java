package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
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
public class PostDaoTest {

    @Autowired
    PostDao dao;

    @Before
    public void setUp() throws Exception {
        List<Post> posts = dao.getAllPosts();
        posts.stream().forEach(Post -> dao.deletePost(Post.getPostID()));
    }

    @Test
    public void addPost() {
        Post post2 = new Post();
        post2.setPostID(1);
        post2.setPostDate(LocalDate.of(2019, 03, 03));
        post2.setPosterName("bob");
        post2.setPost("post");

        post2 = dao.addPost(post2);

        Post post = dao.getPost(post2.getPostID());

        assertEquals(post.getPostID(), post2.getPostID());
        assertEquals(post.getPost(), post2.getPost());
        assertEquals(post.getPosterName(), post2.getPosterName());
    }

    @Test
    public void getPost() {
        Post post2 = new Post();
        post2.setPostID(1);
        post2.setPostDate(LocalDate.of(2019, 03, 03));
        post2.setPosterName("bob");
        post2.setPost("post");

        post2 = dao.addPost(post2);

        Post post = dao.getPost(post2.getPostID());

        assertEquals(post.getPostID(), post2.getPostID());
        assertEquals(post.getPost(), post2.getPost());
        assertEquals(post.getPosterName(), post2.getPosterName());
    }

    @Test
    public void getAllPosts() {
        Post post2 = new Post();
        post2.setPostID(1);
        post2.setPostDate(LocalDate.of(2019, 03, 03));
        post2.setPosterName("bob");
        post2.setPost("post");
        dao.addPost(post2);

        List<Post> posts = dao.getAllPosts();
        assertEquals(posts.size(), 1);
    }

    @Test
    public void getPostByPoster() {
        Post post2 = new Post();
        post2.setPostID(1);
        post2.setPostDate(LocalDate.of(2019, 03, 03));
        post2.setPosterName("bob");
        post2.setPost("post");

        dao.addPost(post2);

        List<Post> posts = dao.getPostByPoster(post2.getPosterName());
        assertEquals(3, post2.getPostID());

    }

    @Test
    public void updatePost() {

        Post post2 = new Post();
        post2.setPostID(1);
        post2.setPostDate(LocalDate.of(2019, 03, 03));
        post2.setPosterName("bob");
        post2.setPost("post");

        dao.addPost(post2);

        post2.setPost("new post");

        dao.updatePost(post2);

        Post post = dao.getPost(post2.getPostID());

        assertEquals(post.getPost(), post2.getPost());
    }

    @Test
    public void deletePost() {

        Post post2 = new Post();
        post2.setPostID(1);
        post2.setPostDate(LocalDate.of(2019, 03, 03));
        post2.setPosterName("bob");
        post2.setPost("post");

        dao.addPost(post2);

        dao.deletePost(post2.getPostID());

        Post post = dao.getPost(post2.getPostID());

        assertNull(post);
    }
}