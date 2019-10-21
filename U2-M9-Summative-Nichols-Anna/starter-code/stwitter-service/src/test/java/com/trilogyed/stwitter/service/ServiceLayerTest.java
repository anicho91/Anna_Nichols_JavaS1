package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.util.feign.CommentFeignClient;
import com.trilogyed.stwitter.util.feign.PostFeignClient;
import com.trilogyed.stwitter.util.feign.model.Comment;
import com.trilogyed.stwitter.util.feign.model.Post;
import com.trilogyed.stwitter.viewmodel.PostViewModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@SpringBootTest
public class ServiceLayerTest {

    @Autowired
    ServiceLayer service;
    @Autowired
    CommentFeignClient cFeign;
    @Autowired
    PostFeignClient pFeign;
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Before
    public void setUp() throws Exception {
        setUpPostMock();
        setUpCommentMock();
        rabbitTemplate = mock(RabbitTemplate.class);

        service = new ServiceLayer();
    }

    //TESTS

    @Test
    public void addPostVm() {
        PostViewModel pvm = new PostViewModel();
        pvm.setPostDate(LocalDate.of(2019,03,03));
        pvm.setPosterName("Tim");
        pvm.setPostContent("Post post post");
        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCommenterName("Bob");
        comment.setCommentDate(LocalDate.of(2019,03,03));
        comment.setCommentContent("Commentcomment");
        comment.setCommentContent("comment");

        List<Comment> comments = new ArrayList<>();
        comments.add(comment);

        pvm.setComments(comments);
        pvm.setPostId(1);

        service.addPostVm(pvm);

        assertNotNull(pvm);

    }

    @Test
    public void getPostVm() {

        PostViewModel pvm = new PostViewModel();
        pvm.setPostId(1);
        pvm.setPostDate(LocalDate.of(2019,03,03));
        pvm.setPosterName("Tim");
        pvm.setPostContent("Post post post");
        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCommenterName("Bob");
        comment.setCommentDate(LocalDate.of(2019,03,03));
        comment.setCommentContent("Commentcomment");
        comment.setCommentContent("comment");

        List<Comment> comments = new ArrayList<>();
        comments.add(comment);

        pvm.setComments(comments);

//        service.addPostVm(pvm);


        assertEquals(pvm, service.getPostVm(1));

    }

    @Test
    public void getPostByPosters() {

        PostViewModel pvm = new PostViewModel();
        pvm.setPostId(1);
        pvm.setPostDate(LocalDate.of(2019,03,03));
        pvm.setPosterName("Tim");
        pvm.setPostContent("Post post post");
        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCommenterName("Bob");
        comment.setCommentDate(LocalDate.of(2019,03,03));
        comment.setCommentContent("Commentcomment");
        comment.setCommentContent("comment");

        List<Comment> comments = new ArrayList<>();
        comments.add(comment);

        pvm.setComments(comments);

        PostViewModel tested = service.getPostByPosters("Bob");

        assertEquals(pvm, tested);

    }


    //MOCKS

    private void setUpPostMock(){
        pFeign = mock(PostFeignClient.class);
        Post post = new Post();
        post.setPostID(1);
        post.setPostDate(LocalDate.of(2019, 03, 03));
        post.setPosterName("Tim");
        post.setPost("Post post post");

        Post post2 = new Post();
        post2.setPostID(1);
        post2.setPostDate(LocalDate.of(2019, 03, 03));
        post2.setPosterName("Tim");
        post2.setPost("Post post post");

        List<Post> pList = new ArrayList<>();
        pList.add(post);

        doReturn(post).when(pFeign).getPost(1);
        doReturn(post).when(pFeign).getPostByPoster("Tim");
    }

    private void setUpCommentMock(){
        cFeign = mock(CommentFeignClient.class);
        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCommenterName("Bob");
        comment.setCommentDate(LocalDate.of(2019, 03, 03));
        comment.setCommentContent("Comment, comment, comment");

        Comment comment2 = new Comment();
        comment2.setCommentId(1);
        comment2.setPostId(1);
        comment2.setCommenterName("Bob");
        comment2.setCommentDate(LocalDate.of(2019, 03, 03));
        comment2.setCommentContent("Comment, comment, comment");

        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        comments.add(comment2);

        doReturn(comments).when(cFeign).getCommentsByPost(1);
    }

}