package com.bytedance.juejin.pin.domain.comment.event;

import com.bytedance.juejin.pin.domain.comment.Comment;
import com.bytedance.juejin.pin.domain.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommentCreatedEvent {

    private final Comment comment;

    private final User user;
}
