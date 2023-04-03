package com.bytedance.juejin.domain.like;

import com.bytedance.juejin.domain.pin.Pin;

public interface PinLike extends Like {

    @Override
    Pin getLiked();
}
