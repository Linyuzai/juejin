package com.bytedance.juejin.pin.domain.like;

import com.bytedance.juejin.pin.domain.like.view.LikeCreateCommand;
import com.bytedance.juejin.pin.domain.user.User;

public interface LikeFacadeAdapter {

    Like from(LikeCreateCommand create, User user);
}
