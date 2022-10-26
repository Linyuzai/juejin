package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.basic.domain.DomainEntity;
import com.bytedance.juejin.pin.domain.pin.Pins;
import com.bytedance.juejin.pin.domain.user.User;
import com.bytedance.juejin.pin.domain.user.Users;

/**
 * 圈子
 */
public interface Club extends DomainEntity {

    /**
     * 圈子名称
     */
    String getName();

    /**
     * 圈子图标
     */
    String getLogo();

    /**
     * 圈子标签
     */
    String getTag();

    /**
     * 圈子描述
     */
    String getDescription();

    /**
     * 圈子公告
     */
    String getAnnouncement();

    /**
     * 圈子管理员
     */
    User getAdmin();

    /**
     * 关注圈子的用户
     */
    Users getUsers();

    /**
     * 圈子下的沸点
     */
    Pins getPins();
}
