package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.util.feign.model.Post;
import com.trilogyed.stwitter.viewmodel.PostViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "post-service")
public interface PostFeignClient {

    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable int id);

    @GetMapping("post/user/{poster_name}")
    public Post getPostByPoster(@PathVariable String poster_name);
}
