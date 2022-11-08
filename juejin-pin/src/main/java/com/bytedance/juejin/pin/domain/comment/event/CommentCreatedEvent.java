package com.bytedance.juejin.pin.domain.comment.event;

import com.bytedance.juejin.pin.domain.comment.Comment;
import com.bytedance.juejin.pin.domain.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 评论创建事件
 */
@Getter
@RequiredArgsConstructor
public class CommentCreatedEvent {

    /**
     * 创建的评论
     */
    private final Comment comment;

    /**
     * 评论的用户
     */
    private final User user;
}
