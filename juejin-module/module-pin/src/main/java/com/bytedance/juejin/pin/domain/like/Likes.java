package com.bytedance.juejin.pin.domain.like;

import com.bytedance.juejin.basic.domain.DomainCollection;
import com.bytedance.juejin.pin.domain.user.User;

/**
 * 点赞集合
 */
public interface Likes extends DomainCollection<Like> {

    /**
     * 用户是否点赞
     */
    boolean isLiked(User user);
}
