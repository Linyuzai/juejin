package com.bytedance.juejin.pin.domain.like;

import com.bytedance.juejin.basic.condition.LambdaConditions;
import com.bytedance.juejin.basic.domain.DomainEventPublisher;
import com.bytedance.juejin.basic.exception.JuejinException;
import com.bytedance.juejin.basic.exception.JuejinNotFoundException;
import com.bytedance.juejin.pin.domain.PinOrComment;
import com.bytedance.juejin.pin.domain.comment.Comment;
import com.bytedance.juejin.pin.domain.like.event.LikeCreatedEvent;
import com.bytedance.juejin.pin.domain.like.event.LikeDeletedEvent;
import com.bytedance.juejin.pin.domain.like.view.LikeCreateCommand;
import com.bytedance.juejin.pin.domain.like.view.LikeDeleteCommand;
import com.bytedance.juejin.pin.domain.pin.Pin;
import com.bytedance.juejin.pin.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    @Autowired
    private LikeFacadeAdapter likeFacadeAdapter;

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private DomainEventPublisher eventPublisher;

    public void create(LikeCreateCommand create, User user) {
        Like like = likeFacadeAdapter.from(create, user);
        if (like.getOwner().getLikes().isLiked(user)) {
            throw new JuejinException("Already liked");
        }
        likeRepository.create(like);
        eventPublisher.publish(new LikeCreatedEvent(like, user));
    }

    public void delete(LikeDeleteCommand delete, User user) {
        LambdaConditions queryConditions = new LambdaConditions();
        if (delete.getCommentId() == null) {
            queryConditions.equal(Pin::getId, delete.getPinId());
        } else {
            queryConditions.equal(Comment::getId, delete.getCommentId());
        }
        Like like = likeRepository.query(queryConditions);
        if (like == null) {
            throw new JuejinNotFoundException(Like.class, "");
        }
        PinOrComment owner = like.getOwner();
        LambdaConditions conditions = new LambdaConditions();
        if (owner.isPin()) {
            conditions.equal(Pin::getId, owner.getId());
        }
        if (owner.isComment()) {
            conditions.equal(Comment::getId, owner.getId());
        }
        conditions.equal(User::getId, user.getId());
        likeRepository.delete(conditions);
        eventPublisher.publish(new LikeDeletedEvent(like, user));
    }
}
