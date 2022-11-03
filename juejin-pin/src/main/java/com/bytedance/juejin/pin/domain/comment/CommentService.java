package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.basic.condition.LambdaConditions;
import com.bytedance.juejin.basic.domain.DomainEventPublisher;
import com.bytedance.juejin.basic.domain.DomainService;
import com.bytedance.juejin.basic.exception.JuejinNotFoundException;
import com.bytedance.juejin.pin.domain.comment.event.CommentCreatedEvent;
import com.bytedance.juejin.pin.domain.comment.event.CommentDeletedEvent;
import com.bytedance.juejin.pin.domain.comment.view.CommentCreateCommand;
import com.bytedance.juejin.pin.domain.comment.view.CommentDeleteCommand;
import com.bytedance.juejin.pin.domain.like.LikeRepository;
import com.bytedance.juejin.pin.domain.pin.Pin;
import com.bytedance.juejin.pin.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CommentService implements DomainService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private CommentFacadeAdapter commentFacadeAdapter;

    @Autowired
    private DomainEventPublisher eventPublisher;

    public void create(CommentCreateCommand create, User user) {
        Comment comment = commentFacadeAdapter.from(create, user);
        commentRepository.create(comment);
        eventPublisher.publish(new CommentCreatedEvent(comment, user));
    }

    @Transactional
    public void delete(CommentDeleteCommand delete, User user) {
        Comment comment = commentRepository.get(delete.getId());
        if (comment == null) {
            throw new JuejinNotFoundException(Comment.class, delete.getId());
        }
        commentRepository.delete(comment);
        //删除评论下面的评论
        LambdaConditions deleteCommentsCondition = new LambdaConditions();
        Set<String> commentIds = new HashSet<>();
        collectCommentIds(comment, commentIds);
        deleteCommentsCondition.in(Comment::getId, commentIds);
        commentRepository.delete(deleteCommentsCondition);
        //删除评论下面的点赞
        LambdaConditions deleteLikesCondition = new LambdaConditions();
        deleteLikesCondition.in(Comment::getId, commentIds);
        likeRepository.delete(deleteLikesCondition);
        afterTransactionCommit(() ->
                eventPublisher.publish(new CommentDeletedEvent(comment, user)));
    }

    protected void collectCommentIds(Comment comment, Collection<String> commentIds) {
        commentIds.add(comment.getId());
        comment.getComments().stream().forEach(it -> collectCommentIds(it, commentIds));
    }
}
