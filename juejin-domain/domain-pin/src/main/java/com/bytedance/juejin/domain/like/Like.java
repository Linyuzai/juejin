package com.bytedance.juejin.domain.like;

import com.bytedance.juejin.domain.user.User;
import com.github.linyuzai.domain.core.DomainEntity;
import com.github.linyuzai.domain.core.DomainObject;

import java.util.Date;

/**
 * 点赞
 */
public interface Like extends DomainEntity {

    DomainObject getLiked();

    User getUser();

    Date getCreateTime();
}
