package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.util.feign.CommentFeignClient;
import com.trilogyed.stwitter.util.feign.PostFeignClient;
import com.trilogyed.stwitter.util.feign.model.Comment;
import com.trilogyed.stwitter.util.feign.model.Post;
import com.trilogyed.stwitter.viewmodel.PostViewModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ServiceLayer {

    @Autowired
    private static final String EXCHANGE = "comment-exchange";
    @Autowired
    private static final String ROUTING_KEY = "comment.create.stwitterService";
    @Autowired
    private RabbitTemplate rabbit;
    @Autowired
    private CommentFeignClient cFeign;
    @Autowired
    private PostFeignClient pFeign;

    @Transactional
    public PostViewModel addPostVm(PostViewModel pvm){
        Post post = new Post();

        pvm = new PostViewModel();
        pvm.setPostContent(post.getPost());
        pvm.setPostDate(post.getPostDate());
        pvm.setPosterName(post.getPosterName());
        int postId = post.getPostID();
        pvm.setPostId(postId);
        pvm.getComments().stream().map(comment -> new Comment(comment.getCommentId(), postId,
                comment.getCommenterName(), comment.getCommentDate(), comment.getCommentContent()))
                .forEach(rabbit::convertAndSend);

        return pvm;
    }

    public PostViewModel getPostVm(int id){

        Post post = pFeign.getPost(id);
        List<Comment> comments = cFeign.getCommentsByPost(id);

        PostViewModel pvm = new PostViewModel();
        pvm.setPostId(post.getPostID());
        pvm.setPostDate(post.getPostDate());
        pvm.setPosterName(post.getPosterName());
        pvm.setPostContent(post.getPost());
        pvm.setComments(comments);

        return pvm;

    }

    public PostViewModel getPostByPosters(String poster_name){

        Post post = pFeign.getPostByPoster(poster_name);
        List<Comment> comments = cFeign.getCommentsByPost(post.getPostID());

        PostViewModel pvm = new PostViewModel();
        pvm.setPostId(post.getPostID());
        pvm.setPostDate(post.getPostDate());
        pvm.setPosterName(post.getPosterName());
        pvm.setPostContent(post.getPost());
        pvm.setComments(comments);

        return pvm;

    }

}
