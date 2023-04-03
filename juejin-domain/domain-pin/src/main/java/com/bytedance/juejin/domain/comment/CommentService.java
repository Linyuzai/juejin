package com.bytedance.juejin.domain.comment;

import com.bytedance.juejin.domain.comment.event.CommentCreatedEvent;
import com.bytedance.juejin.domain.comment.event.CommentDeletedEvent;
import com.bytedance.juejin.domain.user.User;
import com.github.linyuzai.domain.core.DomainEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 评论领域服务
 */
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private DomainEventPublisher eventPublisher;

    public void create(Comment comment, User user) {
        commentRepository.create(comment);
        eventPublisher.publish(new CommentCreatedEvent(comment, user));
    }

    public void delete(Comment comment, User user) {
        commentRepository.delete(comment);
        eventPublisher.publish(new CommentDeletedEvent(comment, user));
    }
}
