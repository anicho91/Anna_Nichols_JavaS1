package com.trilogyed.commentqueueconsumer;

import com.trilogyed.commentqueueconsumer.feign.CommentFeign;
import com.trilogyed.commentqueueconsumer.messages.Comment;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @Autowired
    CommentFeign commentFeign;

    @RabbitListener(queues = CommentQueueConsumerApplication.QUEUE_NAME)
    public void receiveMessage(Comment msg) {

        commentFeign.createComment(msg);

    }


}
