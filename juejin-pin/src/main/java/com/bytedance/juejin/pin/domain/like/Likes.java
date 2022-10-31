package com.bytedance.juejin.pin.domain.like;

import com.bytedance.juejin.basic.domain.DomainCollection;
import com.bytedance.juejin.pin.domain.user.User;

public interface Likes extends DomainCollection<Like> {

    boolean isLiked(User user);
}
