package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.basic.domain.DomainEntity;
import com.bytedance.juejin.pin.domain.pin.Pins;
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
     * 圈子类别
     */
    String getCategory();

    /**
     * 圈子描述
     */
    String getDescription();

    /**
     * 圈子公告
     */
    String getAnnouncement();

    /**
     * 圈子用户
     */
    Users getUsers();

    /**
     * 圈子沸点
     */
    Pins getPins();
}
