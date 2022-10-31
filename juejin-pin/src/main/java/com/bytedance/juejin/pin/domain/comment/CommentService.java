package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.basic.domain.DomainEventPublisher;
import com.bytedance.juejin.basic.exception.JuejinNotFoundException;
import com.bytedance.juejin.pin.domain.comment.event.CommentCreatedEvent;
import com.bytedance.juejin.pin.domain.comment.event.CommentDeletedEvent;
import com.bytedance.juejin.pin.domain.comment.view.CommentCreateCommand;
import com.bytedance.juejin.pin.domain.comment.view.CommentDeleteCommand;
import com.bytedance.juejin.pin.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentFacadeAdapter commentFacadeAdapter;

    @Autowired
    private DomainEventPublisher eventPublisher;

    public void create(CommentCreateCommand create, User user) {
        Comment comment = commentFacadeAdapter.from(create, user);
        commentRepository.create(comment);
        eventPublisher.publish(new CommentCreatedEvent(comment, user));
    }

    public void delete(CommentDeleteCommand delete, User user) {
        Comment comment = commentRepository.get(delete.getId());
        if (comment == null) {
            throw new JuejinNotFoundException(Comment.class, delete.getId());
        }
        commentRepository.delete(comment);
        eventPublisher.publish(new CommentDeletedEvent(comment, user));
    }
}
