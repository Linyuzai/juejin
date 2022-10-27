package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.basic.domain.DomainEntity;
import com.bytedance.juejin.pin.domain.PinOrComment;
import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.comment.Comments;
import com.bytedance.juejin.pin.domain.like.Likes;
import com.bytedance.juejin.pin.domain.user.User;

/**
 * 沸点
 */
public interface Pin extends PinOrComment, DomainEntity {

    String getContent();

    Club getClub();

    User getUser();

    Comments getComments();

    Likes getLikes();

    Long getCreateTime();
}
