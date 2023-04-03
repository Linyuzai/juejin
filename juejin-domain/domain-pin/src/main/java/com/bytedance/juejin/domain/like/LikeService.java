package com.bytedance.juejin.domain.like;

import com.bytedance.juejin.domain.like.event.LikeCreatedEvent;
import com.bytedance.juejin.domain.like.event.LikeDeletedEvent;
import com.bytedance.juejin.domain.user.User;
import com.github.linyuzai.domain.core.DomainEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 点赞领域服务
 */
@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private DomainEventPublisher eventPublisher;

    public void create(Like like, User user) {
        likeRepository.create(like);
        eventPublisher.publish(new LikeCreatedEvent(like, user));
    }

    public void delete(Like like, User user) {
        likeRepository.delete(like);
        eventPublisher.publish(new LikeDeletedEvent(like, user));
    }
}
