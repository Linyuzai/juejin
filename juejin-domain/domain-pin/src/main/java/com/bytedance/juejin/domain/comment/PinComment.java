package com.bytedance.juejin.domain.comment;

import com.bytedance.juejin.domain.pin.Pin;

public interface PinComment extends Comment {

    @Override
    Pin getReplyTo();
}
