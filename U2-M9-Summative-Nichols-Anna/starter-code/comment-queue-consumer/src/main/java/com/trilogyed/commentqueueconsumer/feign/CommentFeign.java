package com.trilogyed.commentqueueconsumer.feign;

import com.trilogyed.commentqueueconsumer.messages.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:6868", name = "comment-service")
public interface CommentFeign {

    @PostMapping("/comments")
    Comment createComment(@RequestBody Comment comment);

}
