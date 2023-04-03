package com.bytedance.juejin.domain.pin;

import com.bytedance.juejin.domain.club.Club;
import com.bytedance.juejin.domain.comment.PinComments;
import com.bytedance.juejin.domain.like.PinLikes;
import com.bytedance.juejin.domain.user.User;
import com.github.linyuzai.domain.core.DomainEntity;

import java.util.Date;

/**
 * 沸点
 */
public interface Pin extends DomainEntity {

    Club getClub();

    String getContent();

    User getUser();

    PinComments getComments();

    PinLikes getLikes();

    Date getCreateTime();
}
