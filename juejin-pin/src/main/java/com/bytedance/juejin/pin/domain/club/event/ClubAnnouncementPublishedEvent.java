package com.bytedance.juejin.pin.domain.club.event;

import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 沸点圈子公告发布事件
 */
@Getter
@RequiredArgsConstructor
public class ClubAnnouncementPublishedEvent {

    /**
     * 发布公告的圈子
     */
    private final Club club;

    /**
     * 公告内容
     */
    private final String announcement;

    /**
     * 发布公告的用户
     */
    private final User user;
}
