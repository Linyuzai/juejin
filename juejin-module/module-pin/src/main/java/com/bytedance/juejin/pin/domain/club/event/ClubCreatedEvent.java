package com.bytedance.juejin.pin.domain.club.event;

import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 沸点圈子创建事件
 */
@Getter
@RequiredArgsConstructor
public class ClubCreatedEvent {

    /**
     * 创建的圈子
     */
    private final Club club;

    /**
     * 创建的用户
     */
    private final User user;
}
