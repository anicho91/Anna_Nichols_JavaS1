package com.trilogyed.comment.service;

import com.trilogyed.comment.dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentDao commentDao;


}
