package com.bytedance.juejin.pin.domain.like.event;

import com.bytedance.juejin.pin.domain.like.Like;
import com.bytedance.juejin.pin.domain.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LikeDeletedEvent {

    private final Like like;

    private final User user;
}
