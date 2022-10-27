package com.bytedance.juejin.pin.domain;

import com.bytedance.juejin.pin.domain.comment.Comment;
import com.bytedance.juejin.pin.domain.pin.Pin;

public interface PinOrComment {

    default boolean isPin() {
        return this instanceof Pin;
    }

    default boolean isComment() {
        return this instanceof Comment;
    }
}
