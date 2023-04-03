package com.bytedance.juejin.pin.domain.like;

import com.bytedance.juejin.domain.like.Like;
import com.bytedance.juejin.domain.user.User;
import com.bytedance.juejin.pin.domain.like.view.LikeCreateCommand;

/**
 * 点赞模型与视图的转换适配器
 */
public interface LikeFacadeAdapter {

    Like from(LikeCreateCommand create, User user);
}
