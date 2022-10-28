package com.bytedance.juejin.pin.domain.club.event;

import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 沸点圈子更新事件
 */
@Getter
@RequiredArgsConstructor
public class ClubUpdatedEvent {

    /**
     * 旧的圈子
     */
    private final Club oldClub;

    /**
     * 新的圈子
     */
    private final Club newClub;

    /**
     * 更新的用户
     */
    private final User user;
}
