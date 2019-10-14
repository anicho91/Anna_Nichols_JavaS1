package com.trilogyed.stwitter.viewmodel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.trilogyed.stwitter.util.feign.model.Comment;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class PostViewModel {
    private Integer postId;
    private String postContent;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate postDate;
    private String posterName;
    private List<Comment> comments;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public PostViewModel(Integer postId, String postContent, LocalDate postDate, String posterName, List<Comment> comments) {
        this.postId = postId;
        this.postContent = postContent;
        this.postDate = postDate;
        this.posterName = posterName;
        this.comments = comments;
    }

    public PostViewModel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostViewModel that = (PostViewModel) o;
        return Objects.equals(postId, that.postId) &&
                Objects.equals(postContent, that.postContent) &&
                Objects.equals(postDate, that.postDate) &&
                Objects.equals(posterName, that.posterName) &&
                Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postContent, postDate, posterName, comments);
    }
}
