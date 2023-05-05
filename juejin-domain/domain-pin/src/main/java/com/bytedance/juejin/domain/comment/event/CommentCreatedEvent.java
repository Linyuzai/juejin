package com.bytedance.juejin.domain.comment.event;

import com.bytedance.juejin.domain.comment.Comment;
import com.bytedance.juejin.domain.user.User;
import com.github.linyuzai.domain.core.DomainContext;
import com.github.linyuzai.domain.core.DomainEventPublisher;
import com.github.linyuzai.domain.core.event.DomainEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 评论创建事件
 */
@Getter
@RequiredArgsConstructor
public class CommentCreatedEvent implements DomainEvent {

    /**
     * 创建的评论
     */
    private final Comment comment;

    /**
     * 评论的用户
     */
    private final User user;

    @Override
    public void onPublish(DomainContext context, DomainEventPublisher publisher) {

    }
}
