package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.util.feign.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "comment-service")
public interface CommentFeignClient {

    @GetMapping("/comments/{id}")
    public Comment getComment(@PathVariable int id);

    @GetMapping("/comments/posts/{postid}")
    public List<Comment> getCommentsByPost(@PathVariable int postid);

}
