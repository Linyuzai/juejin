package com.bytedance.juejin.pin.domain;

import com.bytedance.juejin.basic.domain.DomainObject;
import com.bytedance.juejin.pin.domain.comment.Comment;
import com.bytedance.juejin.pin.domain.comment.Comments;
import com.bytedance.juejin.pin.domain.like.Likes;
import com.bytedance.juejin.pin.domain.pin.Pin;
import com.bytedance.juejin.pin.domain.user.User;

public interface PinOrComment extends DomainObject {

    String getContent();

    User getUser();

    Comments getComments();

    Likes getLikes();

    Long getCreateTime();

    default boolean isPin() {
        return this instanceof Pin;
    }

    default Pin asPin() {
        return (Pin) this;
    }

    default boolean isComment() {
        return this instanceof Comment;
    }

    default Comment asComment() {
        return (Comment) this;
    }
}
