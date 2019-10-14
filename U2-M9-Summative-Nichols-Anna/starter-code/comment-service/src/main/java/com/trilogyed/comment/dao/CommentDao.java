package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;

import java.util.List;

public interface CommentDao {
    Comment addComment(Comment comment);

    Comment getComment(int id);

    List<Comment> getAllComments();

    void updateComment(Comment comment);

    void deleteComment(int id);
}
